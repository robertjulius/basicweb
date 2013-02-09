function fitContent(iFrame) {
	iFrame.height(iFrame.contents().height());
	iFrame.width(iFrame.contents().width());
}

function confirmAction() {
	return confirm('Are you sure want to perform this action?');
}