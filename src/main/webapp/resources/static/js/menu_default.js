$(document).ready(function() {
    jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.buypage__counter input');

    jQuery(".menu-btn").on("click",function (e) {
        e.preventDefault();

        jQuery(this).toggleClass("menu-btn_active");
        jQuery(".menubox").toggleClass("menubox-anime")
        jQuery(".main").toggleClass("main-blur")
        jQuery("body").toggleClass("no_scroll")
    });

});
