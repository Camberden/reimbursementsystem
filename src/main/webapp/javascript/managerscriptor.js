
window.onload = function() {
	document.getElementById("pendingformanager").addEventListener('click', getReimbursementsByPendingStatus);
	document.getElementById("managerapprovals").addEventListener('click', getReimbursementsByApprovedStatus);
	document.getElementById("managerdenials").addEventListener('click', getReimbursementsByDeniedStatus);

}


// PENDING STATUS
// GET APPROPRIATE LIST


function getReimbursementsByPendingStatus() {
	
	console.log("Within the function!")
	let xhr = new XMLHttpRequest();
		
	xhr.onreadystatechange = function() {
			
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				let rListByName = JSON.parse(xhr.responseText);
				console.log('Pulling all reimbursements by Pending Status!');
				console.log(rListByName);
				generateTablePendings(rListByName);
		}
}
	
	xhr.open('POST', 'http://localhost:9001/Projectone/checkAllPendings.json');
	xhr.send();
	
}

function generateTablePendings(rListByName) {
    
    let table = document.getElementById("tabletablePENDING");
    
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











// APPROVED STATUS
// GET APPROPRIATE LIST

function getReimbursementsByApprovedStatus() {
	
	console.log("Within the approved function!")
	let xhr = new XMLHttpRequest();
		
	xhr.onreadystatechange = function() {
			
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				let rListByName = JSON.parse(xhr.responseText);
				console.log('Pulling all reimbursements by Approved Status!');
				console.log(rListByName);
				generateTableApprovals(rListByName);
		}
}
	
	xhr.open('POST', 'http://localhost:9001/Projectone/checkAllApprovals.json');
	xhr.send();
	
}

function generateTableApprovals(rListByName) {
    
    let table = document.getElementById("tabletableAPPROVALS");
    
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













// DENIED STATUS
// GET APPROPRIATE LIST

function getReimbursementsByDeniedStatus() {
	
	console.log("Within the Denied function!")
	let xhr = new XMLHttpRequest();
		
	xhr.onreadystatechange = function() {
			
			if (xhr.readyState == 4 && xhr.status == 200) {
				
				let rListByName = JSON.parse(xhr.responseText);
				console.log('Pulling all reimbursements by Denied Status!');
				console.log(rListByName);
				generateTableDenials(rListByName);
		}
}
	
	xhr.open('POST', 'http://localhost:9001/Projectone/checkAllDenials.json');
	xhr.send();
	
}

function generateTableDenials(rListByName) {
    
    let table = document.getElementById("tabletableDENIALS");
    
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
  
    column.appendChild(document.createTextNode("Author"));
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




