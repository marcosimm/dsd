<section id="clients" class="main">
    <div class="container">
        <div class="row-fluid">
            <div class="span2">
                <div class="clearfix">
                    <h4 class="pull-left">Nuestros<br>auspiciadores</h4>
                    <div class="pull-right">
                        <a class="prev" href="#myCarousel" data-slide="prev"><i class="icon-angle-left icon-large"></i></a> <a class="next" href="#myCarousel" data-slide="next"><i class="icon-angle-right icon-large"></i></a>
                    </div>
                </div>
                <p>Contamos son la auspicio y respaldo de instituciones privadas y estatales .</p>
            </div>
            <div class="span10">
                <div id="myCarousel" class="carousel slide clients">
                  <div class="carousel-inner"><!-- Carousel items -->
                    <div class="active item">
                        <div class="row-fluid">
                            <ul class="thumbnails">
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client1.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client2.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client3.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client4.png"></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row-fluid">
                            <ul class="thumbnails">
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client4.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client3.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client2.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client1.png"></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="item">
                        <div class="row-fluid">
                            <ul class="thumbnails">
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client1.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client2.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client3.png"></a></li>
                                <li class="span3"><a href="#"><img src="view/images/sample/clients/client4.png"></a></li>
                            </ul>
                        </div>
                    </div>
                </div><!-- /Carousel items -->
            </div>
        </div>
    </div>
</div>
</section>
<footer id="footer"><!--Footer-->
    <div class="container">
        <div class="row-fluid">
            <div class="span5 cp">
                &copy; 2015 All Rights Reserved.
            </div>
            <div class="span6"><!--/Copyright-->
                <ul class="social pull-right">
                    <li><a href="#"><i class="icon-facebook"></i></a></li>
                    <li><a href="#"><i class="icon-twitter"></i></a></li>
                    <li><a href="#"><i class="icon-pinterest"></i></a></li>
                    <li><a href="#"><i class="icon-linkedin"></i></a></li>
                    <li><a href="#"><i class="icon-google-plus"></i></a></li>                       
                    <li><a href="#"><i class="icon-youtube"></i></a></li>
                    <li><a href="#"><i class="icon-tumblr"></i></a></li>                        
                    <li><a href="#"><i class="icon-dribbble"></i></a></li>
                    <li><a href="#"><i class="icon-rss"></i></a></li>
                    <li><a href="#"><i class="icon-github-alt"></i></a></li>
                    <li><a href="#"><i class="icon-instagram"></i></a></li>                   
                </ul>
            </div>
            <div class="span1">
                <a id="gototop" class="gototop pull-right" href="#"><i class="icon-angle-up"></i></a>
            </div><!--/Goto Top-->
        </div>
    </div>
</footer><!--/Footer-->
<script src="view/js/vendor/jquery-1.9.1.min.js"></script>
<script src="view/js/vendor/bootstrap.min.js"></script>
<script src="view/js/main.js"></script><!-- Required javascript files for Slider -->
<script src="view/js/jquery.ba-cond.min.js"></script>
<script src="view/js/jquery.slitslider.js"></script>
<script type="text/javascript"> 
$(function() {
    var Page = (function() {
        var $navArrows = $( '#nav-arrows' ),
        slitslider = $( '#slider' ).slitslider( {
            autoplay : true
        } ),
        init = function() {
            initEvents();
        },
        initEvents = function() {
            $navArrows.children( ':last' ).on( 'click', function() {
                slitslider.next();
                return false;
            });
            $navArrows.children( ':first' ).on( 'click', function() {
                slitslider.previous();
                return false;
            });
        };
        return { init : init };
    })();
    Page.init();
});
</script>
</body>
</html>