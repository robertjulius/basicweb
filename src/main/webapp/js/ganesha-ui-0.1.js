function fitContent(iFrame) {
	iFrame.height(iFrame.contents().height());
	iFrame.width(iFrame.contents().width());
}

function confirmAction() {
	return confirm("Are you sure want to perform this action?");
}

function stripeTable(table) {
	var tableBody = table.children("tbody");
	var rows = tableBody.children("tr");
	for ( var i = 0; i < rows.length; i++) {
		rows.eq(i).attr("class", i % 2 == 0 ? "rowOdd" : "rowEven");
	}
}