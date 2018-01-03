alert("4");
(function (document, $, ns) {
"use strict";
 
$(document).on("click", ".cq-dialog-submit", function (e) {
e.stopPropagation();
e.preventDefault();
debugger;
var $form = $(this).closest("form.foundation-form"),
emailid = $form.find("[name='./phoneNo']").val(),
message, clazz = "coral-Button ",
patterns = {
emailadd:
/^\d{10}$/
 
 };

if((emailid != "" && !patterns.emailadd.test(emailid)) && emailid != null) {
ns.ui.helpers.prompt({
title: Granite.I18n.get("Invalid Input"),
message: "Please Enter a valid phone no",
actions: [{
id: "CANCEL",
text: "CANCEL",
className: "coral-Button"
}],
callback: function (actionId) {
if (actionId === "CANCEL") {
}
}
});
 
}else{
$form.submit();
}
});
})(document, Granite.$, Granite.author);