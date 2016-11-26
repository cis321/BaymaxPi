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

void setup() {

  eHealth.readBloodPressureSensor();
  delay(100);
}

void loop() {

  uint8_t numberOfData = eHealth.getBloodPressureLength();
  delay(100);
  if(numberOfData>0){
        printf("[");
  }

  for (int i = 0; i<numberOfData; i++) {
    // The protocol sends data in this order
    printf("{\"Day\":");
    printf("%d",eHealth.bloodPressureDataVector[i].day);
    printf(",");

    printf("\"Month\":");
    printf("%d",eHealth.numberToMonth(eHealth.bloodPressureDataVector[i].month));
    printf(",");

    printf("\"Year\":");
    printf("%d",2000 + eHealth.bloodPressureDataVector[i].year);
    printf(",");

    printf("\"Hours\":");
    printf("%d",eHealth.bloodPressureDataVector[i].hour);
    printf(",");

    printf("\"Minutes\":");
    printf("%d",eHealth.bloodPressureDataVector[i].minutes);
    printf(",");

    printf("\"Systolic\":");
    printf("%d",30+eHealth.bloodPressureDataVector[i].systolic);
    printf(",");

    printf("\"Diastolic\":");
    printf("%d",eHealth.bloodPressureDataVector[i].diastolic);
    printf(",");

    printf("\"Pulse\":");
    printf("%d",eHealth.bloodPressureDataVector[i].pulse);

    int j = i+1;

    if(j==numberOfData){
      printf("}]");
    } else {
      printf("},");
    }
  }
}

int main (){
  // initialize RestClient
	setup();
	loop();
	return (0);
}
