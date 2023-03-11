$(document).ready(function() {
$('.stocks__items').slick({
    arrows:true,
    dots:true,
    slidesToShow:4,
    slidesToScroll:4,
    speed:1200,
    variableWidth: true,
    swipe:false,
    // adaptiveHeight:true,
});
$('.children__slider').slick({
    arrows:false,
    dots:false,
    adaptiveHeight:false,
    slidesToShow:1,
    slidesToScroll:1,
    autoplay:true,
    speed:1000,
    autoplaySpeed:2500,
    variableWidth: true,
    adaptiveHeight:true,
});

$('.filter__title').click(function(event){

    $(this).toggleClass('active').next().slideToggle(300);
    
});


$('.links__title').click(function(event){

  $(this).toggleClass('active').next().slideToggle(300);
  
});


$('.buypage__slider').slick({
    arrows:true,
    dots:true,
    adaptiveHeight:true,
    variableWidth: true,
    slidesToShow:1,
    slidesToScroll:1,
    speed:800,
    
});

$('.recomendation__slider').slick({
    arrows:true,
    dots:true,
    adaptiveHeight:true,
    variableWidth: true,
    slidesToShow:5,
    slidesToScroll:1,
    speed:300,
    Infinity:true,
    swipe:false,
    // centerMode: true,
    
});

jQuery('<div class="quantity-nav"><div class="quantity-button quantity-up">+</div><div class="quantity-button quantity-down">-</div></div>').insertAfter('.buypage__counter input');
    jQuery('.buypage__counter').each(function() {
      var spinner = jQuery(this),
        input = spinner.find('input[type="number"]'),
        btnUp = spinner.find('.quantity-up'),
        btnDown = spinner.find('.quantity-down'),
        min = input.attr('min'),
        max = input.attr('max');

      btnUp.click(function() {
        var oldValue = parseFloat(input.val());
        if (oldValue >= max) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue + 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });

      btnDown.click(function() {
        var oldValue = parseFloat(input.val());
        if (oldValue <= min) {
          var newVal = oldValue;
        } else {
          var newVal = oldValue - 1;
        }
        spinner.find("input").val(newVal);
        spinner.find("input").trigger("change");
      });

    });

    jQuery(".menu-btn").on("click",function (e) {
        e.preventDefault();
        jQuery(this).toggleClass("menu-btn_active");
    });


});






document.getElementById('btcProduct').onclick = function(){
    calcCost();
};

function calcCost(){
    var selectProd = document.getElementById('selectProduct').value;

    var quantityProd = document.getElementById('quantityProduct').value;

    var total = quantityProd * selectProd;
    document.getElementById('priceProduct').innerHTML = total + ' UAH';
    document.getElementById('infoProduct').style.display = 'flex';

}

