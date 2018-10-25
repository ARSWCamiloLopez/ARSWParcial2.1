/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function getWeatherByCityName() {
    axios.get('weather/' + document.getElementById("mainInput").value)
            .then(function (response) {

                var weatherTable = document.createElement("table");
                weatherTable.setAttribute("class", "table");
                weatherTable.style.width = "50%";

                var tableTitles = ["Temperature", "Pressure", "Humidity", "Min Temperature", "Max Temperature"];

                var titleRow = document.createElement("tr");

                for (var x in tableTitles) {
                    var rowItem = document.createElement("th");
                    rowItem.innerHTML = tableTitles[x];
                    titleRow.appendChild(rowItem);
                }

                weatherTable.appendChild(titleRow);

                for (var x in response.data) {
                    if (x.includes("main")) {
                        var infoRow = document.createElement("tr");
                        for(var y in response.data[x]){
                            var rowItem = document.createElement("td");
                            rowItem.innerHTML = response.data[x][y]
                            infoRow.appendChild(rowItem);
                        }
                        weatherTable.appendChild(infoRow);
                    }                    
                }
                       
                document.getElementById("tableDiv").appendChild(weatherTable);
                
            });
}