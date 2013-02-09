
<section id="indexPage" class="content">
  <h1>Congratulation, ${_r.user.firstName} ${_r.user.lastName}<br />you got sampleBookmarks working!</h1>
  
  <p>Just a very simple prototype of a very basic bookmark application, showing the main concepts of Snow, for login, 
    authentication, REST API in Java.</p>
    
  <p>The source of this application is <a target="gb" href="https://github.com/BriteSnow/sampleBookmarks">on GitHub</a></p>

  <div class="row-fluid">
    <div class="span2"></div>
    <div class="span8">
      
      <center>
      <a class="btn btn-primary btn-large" href="bookmarks">Go To Application <br /><small>(page refresh version)</small></a>
      </center>
    </div>      
    <div class="span2"></div>
  </div>
  
  <br style="margin:20px 0" />
  
  <h2>Running Example</h2>
  <strong>JSON API</strong>
  <p>Code: <a href="https://github.com/BriteSnow/sampleBookmarks/blob/master/src/main/java/com/example/samplebookmarks/web/ItemWebHandlers.java#L53">@WebGet("/api/user-items")</a>
    <br />
    Result: <a href="${_r.contextPath}/api/user-items">http://localhost:8080/api/user-items</a>
  </p>
  
  <strong>Freemarker default <em>_r</em> properties</strong>   
  <p><a href="test_r-properties?param1=123">http://localhost:8080/test_r-properties?param1=123</a></p>
                                 

  
</section>