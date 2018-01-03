
(function (document, $, ns) {
     "use strict";
$(document).on("click", ".cq-dialog-submit", function (e) {
    alert("hiiii");
     e.stopPropagation();
     e.preventDefault();
    var $form = $(this).closest("form.foundation-form"), title = $form.find("[name='./jcr:title']").val(), message, clazz = "coral-Button ";
    var fieldd = $(".coral-Multifield");
    var sizee = fieldd.attr("data-minFieldLimit");
    console.log("sizeeeee"+sizee);
    if(($(this).prev('ol').children('li').length) < sizee){

              clazz = clazz + "coral-Button--warning";
    }
    ns.ui.helpers.prompt({
.



             callback: function (actionId) {
                if (actionId === "SUBMIT") {
                    $form.submit();
                }
            }
        });
    });
})(document, Granite.$, Granite.author);