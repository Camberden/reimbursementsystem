
window.onload = function() {
	document.getElementById("reimbursementcard").addEventListener('click', getReimbursementsByName);

}




function getReimbursementsByName() {
	
	console.log("Within the function!")
	let xhr = new XMLHttpRequest();
		
	xhr.onreadystatechange = function() {
			
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				let rListByName = JSON.parse(xhr.responseText);
				console.log('Pulling all reimbursements by username!');
				console.log(rListByName);
				generateTable(rListByName);
		}
}
	
	xhr.open('POST', 'http://localhost:9001/Projectone/displayUsersReimbursements.json');
	xhr.send();
	
}

function generateTable(rListByName) {
    
    let table = document.getElementById("tabletable");
    
    while(table.firstElementChild){
        table.firstElementChild.remove();
        
    }
    
    table.className = 'table';
    let tableBody = document.createElement("tbody");
    let tableHead = document.createElement('thead');
    let tableRow = document.createElement('tr')
    let column = document.createElement('th');
    column.scope = 'col';
    
    column.appendChild(document.createTextNode("ID#"));
    tableRow.appendChild(column);
    column = document.createElement('th');
    
    column.appendChild(document.createTextNode("Amount"));
    tableRow.appendChild(column);
    column = document.createElement('th');
  
    column.appendChild(document.createTextNode("Claimant"));
    tableRow.appendChild(column);
    column = document.createElement('th');

    column.appendChild(document.createTextNode("Status"));
    tableRow.appendChild(column);
    column = document.createElement('th');
    
    column.appendChild(document.createTextNode("Type"));
    tableRow.appendChild(column);
    tableHead.appendChild(tableRow);
   
    var i;
    for (i = 0; i < rListByName.length; i++) {
        
        let tempVar = rListByName[i].reimbId;
        let row = document.createElement('tr');
        let cell = document.createElement('td');
        cell.appendChild(document.createTextNode(tempVar));
        row.appendChild(cell);
        
        tempVar = rListByName[i].amount;
        cell = document.createElement('td');
        cell.appendChild(document.createTextNode(tempVar));
        row.appendChild(cell);
       
        tempVar = rListByName[i].author;
        cell = document.createElement('td');
        cell.appendChild(document.createTextNode(tempVar));
        row.appendChild(cell);
       
        
        tempVar = rListByName[i].statusId;
        cell = document.createElement('td');
        cell.appendChild(document.createTextNode(tempVar));
        row.appendChild(cell);
        
        tempVar = rListByName[i].typeId;
        cell = document.createElement('td');
        cell.appendChild(document.createTextNode(tempVar));
        row.appendChild(cell);
        tableBody.appendChild(row);   
        
    }
    
    table.appendChild(tableHead);
    table.appendChild(tableBody);
    console.log(table);

}

