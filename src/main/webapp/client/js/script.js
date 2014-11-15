$(document).ready(function() {
    $('.mini-popup-trigger').magnificPopup({
        items: {
            src: '.calendario',
            type: 'inline'
        }
    });
 
    $('.dates-picker').on('click', function() {
        $.ajax({
            type: 'get',
            dataType: 'json',
            url: 'dates-booked.json',
            success: function(data) {
                var datesArray = data.bookedDates;
                $('.calendario').pickmeup({
                    format: 'Y-m-d',
                    calendars: 2,
                    first_day: 0,
                    flat: true,
                    mode: 'multiple',
                    min: '2014-01-01',
                    date: datesArray,
                });
            },
            error: function(e) {
                console.log('erorr - ' + e);
            }
        });
    });


//  locale: {  
//days: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"],
//daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
//daysMin: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa", "Su"],
//months: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
//monthsShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
//  }

    //change year value of Month select
    var startYear = $('form select#year-select option:selected').text();
    $('form select#month-select option').each(function(i, e) {
        var beforeDate = $(e).attr('value');
        var newDate = startYear + beforeDate;
        $(e).attr('value', newDate);
    });

    //Select year
    $('form select#year-select').on('change', function() {
        var thisVal = $(this).val();
        var thisText = $("option:selected", this).text();
        $('.calendario').pickmeup('destroy');
        $('.calendario').pickmeup({
            format: 'Y-m-d',
            calendars: 2,
            first_day: 0,
            flat: true,
            mode: 'multiple',
            min: thisVal,
            date: ['2014-10-02', '2014-10-03', '2014-10-04', '2014-10-04', '2014-10-27', '2014-10-28', '2014-11-10', '2015-01-04']
        });
        //change year value of Month select 
        $('form select#month-select').val($("form select#month-select option:first").val());
        $('form select#month-select option').each(function(i, e) {
            var beforeDate2 = $(e).attr('value');
            var cutString = beforeDate2.substring(beforeDate2.indexOf('-'));
            var newDate2 = thisText + cutString;
            $(e).attr('value', newDate2);
        });
    });
    //Select month
    $('form select#month-select').on('change', function() {
        var thisVal = $(this).val();
        $('.calendario').pickmeup('destroy');
        $('.calendario').pickmeup({
            format: 'Y-m-d',
            calendars: 2,
            first_day: 0,
            flat: true,
            mode: 'multiple',
            min: thisVal,
            date: ['2014-10-02', '2014-10-03', '2014-10-04', '2014-10-04', '2014-10-27', '2014-10-28', '2014-11-10', '2015-01-04']
        });
    });



    var isMobile;
    function detectmob() {
        if (navigator.userAgent.match(/Android/i)
                || navigator.userAgent.match(/webOS/i)
                || navigator.userAgent.match(/iPhone/i)
                || navigator.userAgent.match(/iPad/i)
                || navigator.userAgent.match(/iPod/i)
                || navigator.userAgent.match(/BlackBerry/i)
                || navigator.userAgent.match(/Windows Phone/i)
                ) {
            isMobile = true;
        }
        else {
            isMobile = false;
            paralaxBoxes();
            //Paralax and first block onResize
            $(window).resize(function() {
                if (!isMobile) {
                    paralaxBoxes();
                    var viewportHeight2 = $(this).height();
                    $('#first').css('height', viewportHeight2);
                }
            });
        }
    }

//Paralax and first block onResize
    $(window).resize(function() {
        if (!isMobile) {
            var viewportHeight2 = $(this).height();
            $('#first').css('height', viewportHeight2);
        }
    });
    //home screen button
    $("#show-more").click(function() {
        $('html, body').animate({
            scrollTop: $("#hot-ropouse").offset().top
        }, 1000);
    });
    //First block start height
    var viewportHeight = $(window).height();
    $('#first').css('height', viewportHeight);
    //First block background paralax
    $(window).scroll(function() {
        if (!isMobile) {
            var x = $(this).scrollTop();
            $('.first-container header').css('background-position', 'center ' + parseInt(-x / 3) + 'px');
        }
    });
    //Parallax func
    var paralaxBoxes = function() {
        var windowHeight = $(window).outerHeight();
        $('#hot-ropouse').waypoint(function(direction) {
            if (direction === 'down') {
                $(this).addClass('fixed');
                var height = $(this).outerHeight();
                $('#appartaments').css('top', height);
                $('#appartaments').css('paddingBottom', height);
            } else {
                $(this).removeClass('fixed');
                $('#appartaments').css('top', 0);
            }
        });
        $('#appartaments').waypoint(function(direction) {
            if (direction === 'down') {
                $('#hot-ropouse').removeClass('fixed');
                $(this).css('top', 0);
                $(this).css('paddingBottom', 0);
            }
        });
        $('#more-info')
                .waypoint(function(direction) {
                    if (direction === 'down') {
                        console.log('more-info dOWN 100$');
                        var height = $('#appartaments').height();
                        var blockMrgnTo = (height - windowHeight) + 37;
                        $('#appartaments').css('position', 'fixed');
                        $('#appartaments').css('top', -blockMrgnTo);
                        var topMrg = blockMrgnTo + windowHeight;
                        $(this).css('top', topMrg);
                        $(this).css('paddingBottom', topMrg);
                    } else {
                        console.log('more-info dOWN 100$ ELSE');
                        $('#appartaments').css('position', 'relative');
                        $('#appartaments').css('top', 0);
                    }
                }, {offset: '100%'});
        $('#more-info')
                .waypoint(function(direction) {
                    if (direction === 'down') {
                        console.log('more-info dOWN');
                        $('#appartaments').css('position', 'relative');
                        $('#appartaments').css('top', 0);
                        $(this).css('top', 0);
                        $(this).css('paddingBottom', 0);
                        $(this).addClass('fixed');
                        var thisHeight = $(this).outerHeight();
                        var footerH = $('footer').outerHeight();
                        setTimeout(function() {
                            if (windowHeight <= footerH) {
                                var heightTopto = thisHeight;
                            } else {
                                var minus = windowHeight - footerH;
                                var heightTopto = thisHeight - minus;
                            }
                            $('footer').css('top', heightTopto);
                            $('footer').css('paddingBottom', heightTopto);
                        }, 1000);
                    }
                })
                .waypoint(function(direction) {
                    if (direction === 'up') {

                        console.log('more-info up');
                        $('footer').css('top', 0);
                        $('footer').css('paddingBottom', 0);
                        $(this).css('top', 0);
                        $(this).css('paddingBottom', 0);
                        $(this).removeClass('fixed');
                    }
                }, {offset: '1'});
    };
    detectmob();
});