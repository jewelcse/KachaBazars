/*==============================
   PRELOADER
==============================*/
(function($){
    $(window).load(function() {
	    $('#preloader').hide();
    });
})(jQuery);
/*==============================
   SEARCH BUTTON SECRIPT
==============================*/
$(".search-btn").click(function(event){
    event.preventDefault()
    $(".search-section").slideToggle(500);
});

/*==============================
   FIX MENU
==============================*/
(function($){
    // menu fixed
    var navHeight = 40;
    var nav = $('.header-section');
    $(window).scroll(function () {
        if ($(this).scrollTop() > navHeight ) {
            nav.addClass("fixed");
        } else {
            nav.removeClass("fixed");
        }
    });

})(jQuery);

/*==============================
    ISOTOPW WORK
==============================*/
//(function($){
$(window).load(function(){
    var selectedCategory;
    var $grid = $('.featured').isotope({
        itemSelector: '.col-md-3',
        masonry: {
            columnWidth: '.col-md-3',
        },
        getSortData: {
            selectedCategory: function( itemElem ) {
                return $( itemElem ).hasClass( selectedCategory ) ? 0 : 1;
            }
        }
  });
  var $items = $('.featured').find('.featured-items');

  $('.sort-button-group').on( 'click', '.button', function() {
    selectedCategory = $( this ).attr('data-category');
    if ( selectedCategory == 'all' ) {
        $grid.isotope({
            sortBy: 'original-order'
        });
        $items.css({
            opacity: 1
        });
        return;
    }
    var selectedClass = '.' + selectedCategory;
    $items.filter( selectedClass ).css({
        opacity: 1
    });
    $items.not( selectedClass ).css({
        opacity: 0
    });
    $grid.isotope('updateSortData');
    $grid.isotope({ sortBy: 'selectedCategory' });
  });

  $('.button-group').each( function( i, buttonGroup ) {
        var $buttonGroup = $( buttonGroup );
        $buttonGroup.on( 'click', 'li', function() {
            $buttonGroup.find('.active').removeClass('active');
            $( this ).addClass('active');
        });
  });

});

(function($){
    $('.featured').isotope({
    itemSelector: '.featured-items',
    layoutMode: 'masonry'
    });
})(jQuery);

/*==============================
    CLIENT FEEDBACK
==============================*/
(function($){
    var owl = $("#client");
    owl.owlCarousel({
        items : 4,
        itemsDesktop : [1000,3],
        itemsDesktopSmall : [900,2],
        itemsTablet: [600,1],
        itemsMobile : false
    });

    // Custom Navigation Events
    $(".works-next").click(function(){
        owl.trigger('owl.next');
    })
    $(".works-prev").click(function(){
        owl.trigger('owl.prev');
    })
})(jQuery);
/*
$('#feedback').carousel({
    interval: 3000
})*/

/*==============================
    SCROLL ANIMATION
==============================*/
(function($){
     (function() {
      var Util,
        __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

      Util = (function() {
        function Util() {}

        Util.prototype.extend = function(custom, defaults) {
          var key, value;
          for (key in custom) {
            value = custom[key];
            if (value != null) {
              defaults[key] = value;
            }
          }
          return defaults;
        };

        Util.prototype.isMobile = function(agent) {
          return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(agent);
        };

        return Util;

      })();

      this.WOW = (function() {
        WOW.prototype.defaults = {
          boxClass: 'wow',
          animateClass: 'animated',
          offset: 0,
          mobile: true
        };

        function WOW(options) {
          if (options == null) {
            options = {};
          }
          this.scrollCallback = __bind(this.scrollCallback, this);
          this.scrollHandler = __bind(this.scrollHandler, this);
          this.start = __bind(this.start, this);
          this.scrolled = true;
          this.config = this.util().extend(options, this.defaults);
        }

        WOW.prototype.init = function() {
          var _ref;
          this.element = window.document.documentElement;
          if ((_ref = document.readyState) === "interactive" || _ref === "complete") {
            return this.start();
          } else {
            return document.addEventListener('DOMContentLoaded', this.start);
          }
        };

        WOW.prototype.start = function() {
          var box, _i, _len, _ref;
          this.boxes = this.element.getElementsByClassName(this.config.boxClass);
          if (this.boxes.length) {
            if (this.disabled()) {
              return this.resetStyle();
            } else {
              _ref = this.boxes;
              for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                box = _ref[_i];
                this.applyStyle(box, true);
              }
              window.addEventListener('scroll', this.scrollHandler, false);
              window.addEventListener('resize', this.scrollHandler, false);
              return this.interval = setInterval(this.scrollCallback, 50);
            }
          }
        };

        WOW.prototype.stop = function() {
          window.removeEventListener('scroll', this.scrollHandler, false);
          window.removeEventListener('resize', this.scrollHandler, false);
          if (this.interval != null) {
            return clearInterval(this.interval);
          }
        };

        WOW.prototype.show = function(box) {
          this.applyStyle(box);
          return box.className = "" + box.className + " " + this.config.animateClass;
        };

        WOW.prototype.applyStyle = function(box, hidden) {
          var delay, duration, iteration;
          duration = box.getAttribute('data-wow-duration');
          delay = box.getAttribute('data-wow-delay');
          iteration = box.getAttribute('data-wow-iteration');
          return box.setAttribute('style', this.customStyle(hidden, duration, delay, iteration));
        };

        WOW.prototype.resetStyle = function() {
          var box, _i, _len, _ref, _results;
          _ref = this.boxes;
          _results = [];
          for (_i = 0, _len = _ref.length; _i < _len; _i++) {
            box = _ref[_i];
            _results.push(box.setAttribute('style', 'visibility: visible;'));
          }
          return _results;
        };

        WOW.prototype.customStyle = function(hidden, duration, delay, iteration) {
          var style;
          style = hidden ? "visibility: hidden; -webkit-animation-name: none; -moz-animation-name: none; animation-name: none;" : "visibility: visible;";
          if (duration) {
            style += "-webkit-animation-duration: " + duration + "; -moz-animation-duration: " + duration + "; animation-duration: " + duration + ";";
          }
          if (delay) {
            style += "-webkit-animation-delay: " + delay + "; -moz-animation-delay: " + delay + "; animation-delay: " + delay + ";";
          }
          if (iteration) {
            style += "-webkit-animation-iteration-count: " + iteration + "; -moz-animation-iteration-count: " + iteration + "; animation-iteration-count: " + iteration + ";";
          }
          return style;
        };

        WOW.prototype.scrollHandler = function() {
          return this.scrolled = true;
        };

        WOW.prototype.scrollCallback = function() {
          var box;
          if (this.scrolled) {
            this.scrolled = false;
            this.boxes = (function() {
              var _i, _len, _ref, _results;
              _ref = this.boxes;
              _results = [];
              for (_i = 0, _len = _ref.length; _i < _len; _i++) {
                box = _ref[_i];
                if (!(box)) {
                  continue;
                }
                if (this.isVisible(box)) {
                  this.show(box);
                  continue;
                }
                _results.push(box);
              }
              return _results;
            }).call(this);
            if (!this.boxes.length) {
              return this.stop();
            }
          }
        };

        WOW.prototype.offsetTop = function(element) {
          var top;
          top = element.offsetTop;
          while (element = element.offsetParent) {
            top += element.offsetTop;
          }
          return top;
        };

        WOW.prototype.isVisible = function(box) {
          var bottom, offset, top, viewBottom, viewTop;
          offset = box.getAttribute('data-wow-offset') || this.config.offset;
          viewTop = window.pageYOffset;
          viewBottom = viewTop + this.element.clientHeight - offset;
          top = this.offsetTop(box);
          bottom = top + box.clientHeight;
          return top <= viewBottom && bottom >= viewTop;
        };

        WOW.prototype.util = function() {
          return this._util || (this._util = new Util());
        };

        WOW.prototype.disabled = function() {
          return !this.config.mobile && this.util().isMobile(navigator.userAgent);
        };

        return WOW;

      })();

    }).call(this);


    wow = new WOW(
      {
        animateClass: 'animated',
        offset: 100
      }
    );
    wow.init();
})(jQuery);