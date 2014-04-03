function isNotBlank(s) {
	return (s !== null && s !== undefined && s !== '');
}

function isMoney(s) {
	var regexp = "[0-9]+\.[0-9]{2}";
	return s.match(new RegExp(regexp));
}