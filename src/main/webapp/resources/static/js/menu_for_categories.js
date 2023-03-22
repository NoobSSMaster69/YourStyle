$(document).ready(function() {
    jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.buypage__counter input');

    jQuery(".menu-btn").on("click",function (e) {
        e.preventDefault();
        let categories = document.querySelector(".categories__full")
        let st = window.getComputedStyle(categories)
        if(st.right === "0px"){
            jQuery(".close_filters-btn").toggleClass("close_filters-btn_active");
            jQuery(".categories__full").toggleClass("categories_anime");
            jQuery(".sales").toggleClass("main-blur")
            jQuery("body").toggleClass("no_scroll")

        }

        jQuery(this).toggleClass("menu-btn_active");
        jQuery(".menubox").toggleClass("menubox-anime")
        jQuery(".main").toggleClass("main-blur")
        jQuery("body").toggleClass("no_scroll")
    });

});
