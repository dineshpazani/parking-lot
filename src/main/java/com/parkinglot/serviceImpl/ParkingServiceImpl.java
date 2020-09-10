package com.parkinglot.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.parkinglot.model.ParkingMetaModel;
import com.parkinglot.model.ParkingModel;
import com.parkinglot.model.VehicleModel;
import com.parkinglot.service.ParkingService;
import com.parkinglot.service.VechicleService;

@Service
public class ParkingServiceImpl implements ParkingService, VechicleService {

	public static ParkingMetaModel parkingMetaModel;

	public static Map<Integer, ParkingModel> parkingMap = new HashMap<>();

	public static Map<String, VehicleModel> vechilesHistoryMap = new HashMap<>();

	public static Integer nextParkingSlotId = 0;

	@Override
	public ParkingMetaModel addParkingMetaInfo(ParkingMetaModel parkingMetaModel) {
		ParkingServiceImpl.parkingMetaModel = parkingMetaModel;
		return ParkingServiceImpl.parkingMetaModel;
	}

	@Override
	public String parkingIn(ParkingModel parkingModel) {
		
		if (ParkingServiceImpl.parkingMetaModel == null)
			return "Please Intiate parking capacity and charge per second by calling API: addparkingmetainfo";

		if (vechilesHistoryMap.containsKey(parkingModel.getVehicleModel().getVahicleNo()))
			return "Vechile already parked at slot "
					+ vechilesHistoryMap.get(parkingModel.getVehicleModel().getVahicleNo()).getParkingSlotId();

		if (!getNextParkingId())
			return "All Parking lots are filled!";
		parkingModel.getVehicleModel().setInTime(LocalDateTime.now());
		parkingModel.setParkingSlotId(nextParkingSlotId);
		parkingModel.getVehicleModel().setParkingSlotId(parkingModel.getParkingSlotId());
		parkingMap.put(parkingModel.getParkingSlotId(), parkingModel);
		vechilesHistoryMap.put(parkingModel.getVehicleModel().getVahicleNo(), parkingModel.getVehicleModel());

		return "Vechile entry is added to parking lot " + parkingModel.getParkingSlotId();
	}

	@Override
	public VehicleModel parkingOut(String vechileNo) {

		if (vechilesHistoryMap.get(vechileNo) != null) {
			Integer parkingSlotId = vechilesHistoryMap.get(vechileNo).getParkingSlotId();
			if (parkingMap.get(parkingSlotId) != null) {
				parkingMap.remove(parkingSlotId);
				vechilesHistoryMap.get(vechileNo).setOutTime(LocalDateTime.now());
				long diffInHours = java.time.Duration
						.between(vechilesHistoryMap.get(vechileNo).getInTime(), LocalDateTime.now()).getSeconds();
				vechilesHistoryMap.get(vechileNo).setParkedTime((int) diffInHours);
				vechilesHistoryMap.get(vechileNo).setCharged(diffInHours * parkingMetaModel.getChargePerSecond());

				return vechilesHistoryMap.get(vechileNo);
			}
		}
		return null;
	}

	@Override
	public Map<Integer, ParkingModel> getparkedVachilesList() {
		return parkingMap;
	}

	@Override
	public List<VehicleModel> getParkedHistory() {
		return vechilesHistoryMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public VehicleModel getVechilesById(String vechileId) {
		return vechilesHistoryMap.get(vechileId);
	}

	private Boolean getNextParkingId() {

		if (parkingMap.size() >= parkingMetaModel.getParkingCapacity())
			return false;
		else {

			if (nextParkingSlotId >= parkingMetaModel.getParkingCapacity()) {
				nextParkingSlotId = 0;
				for (int i = 1; i < parkingMetaModel.getParkingCapacity(); i++) {
					if (!parkingMap.containsKey((i))) {
						nextParkingSlotId = i;
						break;
					}

				}
			}else {
				nextParkingSlotId++;
			}
			
			return true;
		}
	}

	@Override
	public List<Integer> getAvailableParkingSlots() {
		
		List<Integer> freeSltos = new ArrayList<>();
		Integer max = parkingMetaModel!=null?parkingMetaModel.getParkingCapacity()+1:0;
		IntStream.range(1, max)
		.filter(i -> !parkingMap.containsKey((i))).forEach(i -> {
			freeSltos.add(i);
		});
		return freeSltos;
				
	}

}
