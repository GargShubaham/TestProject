


$(document).on("click", ".cq-dialog-submit", function (e) {
    var field = $(this).parent();
    var size = field.attr("data-minlinksallowed");
    alert(size);
    if (size) {
        var ui = $(window).adaptTo("foundation-ui");
        var totalLinkCount = $(this).prev('ol').children('li').length;
        if (totalLinkCount <= size) {
            ui.alert("Warning", "Maximum " + size + " links are allowed!", "notice");
            return false;
        }
    }
});