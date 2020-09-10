# parking-lot


#Swagger URL: 
http://localhost:8080/swagger-ui.html

#API should call before making any operation:
http://localhost:8080/v1/parkingservice/addparkingmetainfo

Questions: 
#A system, to keep track of incoming vehicles, capture in_time, capture parking time, capture out_time.
API: 
http://localhost:8080/v1/parkingservice/vechilein
http://localhost:8080/v1/parkingservice/vechileout/ka2022

Note Intime, out time, and the charge will automatically calculate per second. 

#In addition,
- for any vehicle number, we should be able to get the current charge for the parking at any given point of time.
API:
http://localhost:8080/v1/vechileservice/getbyid/ka2022

#get the list of vehicles parked with time since parked
API:
http://localhost:8080/v1/vechileservice/getbyid/ka2022

#check if slots are available for parking
API: 
http://localhost:8080/v1/parkingservice/freeslots

#Add Meta data:
http://localhost:8080/v1/parkingservice/addparkingmetainfo
Default post value:
{
  "chargePerHour": 40,
  "parkingCapacity": 3
}

--note : parking intitial capacity is 3.

#Vechiles In:
http://localhost:8080/v1/parkingservice/vechilein
{
  "vehicleModel": {
    "vahicleNo": "ka2021"
  }
}

#Second: 
{
  "vehicleModel": {
    "vahicleNo": "ka2022"
  }
}

#Third:
{
  "vehicleModel": {
    "vahicleNo": "ka2023"
  }
}


#Get All details:
http://localhost:8080/v1/parkingservice/getalldetails



#Out a vechiles:
http://localhost:8080/v1/parkingservice/vechileout/ka2022

Now slot 2 is free. It is will park new vechiles if arrived. 

#To know entire history of parked details:
http://localhost:8080/v1/vechileservice/getalldetails

#Get vechiles charged details in time, out time and chrged amount by vechiles no.
http://localhost:8080/v1/vechileservice/getbyid/ka2022


