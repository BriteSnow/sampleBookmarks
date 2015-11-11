<div id="pageNav" class="navbar navbar-inverse navbar-static-top">
  <div class="navbar-inner">
    <a class="brand" href="${_r.contextPath}/">sampleBookmarks</a>
    <ul class="nav">
      <li class="[#if piIs("/bookmarks")]active[/#if]"><a href="bookmarks">My Bookmarks</a></li>
      [#--
      <li class="[#if piIs("/topics")]active[/#if]"><a href="add">Topics</a></li>
      <li class="[#if piIs("/profile")]active[/#if]"><a href="editprofile">Profile</a></li>
      --]
    </ul>
    <div id="userInfo">
      <label>[#if _r.user??]${_r.user.fullName!"no full name"}[/#if] <a class="logoff">(logoff)</a></label>
      
      
    </div>
  </div>
</div>

