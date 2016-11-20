/*
 *  eHealth sensor platform for Arduino and Raspberry from Cooking-hacks.
 *
 *  Description: "The e-Health Sensor Shield allows Arduino and Raspberry Pi
 *  users to perform biometric and medical applications by using 9 different
 *  sensors: Pulse and Oxygen in Blood Sensor (SPO2), Airflow Sensor (Breathing),
 *  Body Temperature, Electrocardiogram Sensor (ECG), Glucometer, Galvanic Skin
 *  Response Sensor (GSR - Sweating), Blood Pressure (Sphygmomanometer) and
 *  Patient Position (Accelerometer)."
 *
 *  In this example we read the values in volts of EMG sensor and show
 *  these values in the serial monitor.
 *
 *  Copyright (C) 2012 Libelium Comunicaciones Distribuidas S.L.
 *  http://www.libelium.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Version 2.0
 *  Author: Luis Martin & Ahmad Saad & Anartz Nuin
 */

//Include eHealth library
#include "eHealth.h"
#include <sstream>
#include <string>

void setup() {

  eHealth.readBloodPressureSensor();
  delay(100);
}

void loop() {

  std::stringstream ss;

  uint8_t numberOfData = eHealth.getBloodPressureLength();
  printf("Number of measures : ");
  printf("%d\n",numberOfData);
  delay(100);
  if(numberOfData>0){
    ss<<"[";
  }

  for (int i = 0; i<numberOfData; i++) {
    ss<<"{";
    // The protocol sends data in this order
    printf("==========================================");

    printf("Measure number ");
    printf("%d\n",i + 1);
    printf("%d\n",i);

    printf("Date -> ");
    printf("%d",eHealth.bloodPressureDataVector[i].day);
    ss<<"{\"Dia\":"<<eHealth.bloodPressureDataVector[i].day+'0'<<"},";

    printf(" of ");
    printf("%d",eHealth.numberToMonth(eHealth.bloodPressureDataVector[i].month));
    ss<<"{\"Mes\":"<<eHealth.bloodPressureDataVector[i].month+'0'<<"},";
    printf(" of ");
    printf("%d",2000 + eHealth.bloodPressureDataVector[i].year);
    ss<<"{\"Año\":"<<2000 + eHealth.bloodPressureDataVector[i].year+'0'<<"},";
    printf(" at ");

    if (eHealth.bloodPressureDataVector[i].hour < 10) {
      printf("%d",0); // Only for best representation.
    }

    printf("%d",eHealth.bloodPressureDataVector[i].hour);
    ss<<"{\"Hora\":"<<eHealth.bloodPressureDataVector[i].hour+'0'<<"},";
    printf(":");

    if (eHealth.bloodPressureDataVector[i].minutes < 10) {
      printf("%d",0);// Only for best representation.
    }
    printf("%d\n",eHealth.bloodPressureDataVector[i].minutes);
    ss<<"{\"Minutos\":"<<eHealth.bloodPressureDataVector[i].minutes+'0'<<"},";

    printf("Systolic value : ");
    printf("%d\n",30+eHealth.bloodPressureDataVector[i].systolic);
    ss<<"{\"Sistólica\":"<<30+eHealth.bloodPressureDataVector[i].systolic+'0'<<"},";
    printf(" mmHg\n");

    printf("Diastolic value : ");
    printf("%d",eHealth.bloodPressureDataVector[i].diastolic);
    ss<<"{\"Diastólica\":"<<eHealth.bloodPressureDataVector[i].diastolic+'0'<<"},";
    printf(" mmHg\n");

    printf("Pulse value : ");
    printf("%d",eHealth.bloodPressureDataVector[i].pulse);
    ss<<"{\"Pulso\":"<<eHealth.bloodPressureDataVector[i].pulse+'0'<<"}";
    printf(" bpm\n");

    int j = i+1;

    if(j==numberOfData){
      ss<<"}]";
      std::string s = ss.str();
      printf(s.c_str());
    } else {
      ss<<"},";
    }
  }
  // RestClient::Response r = RestClient::post("localhost:4000/m2m/applications/TempSensor1/containers/tempContainer/contentInstances/", "text/json", ss.str().c_str());
}

int main (){
  // initialize RestClient
	setup();
	loop();
	return (0);
}
