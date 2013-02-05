<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>sampleBookmarks: Simple Snow and brite.js demo</title>
    
    <link rel="stylesheet" type="text/css" href="${_r.contextPath}/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${_r.contextPath}/css/main.css">
    
    <script type="text/javascript" src="${_r.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${_r.contextPath}/js/jquery.form.js"></script>
    
    <script type="text/javascript" src="${_r.contextPath}/js/brite-snapshot.js"></script>
    
    <script type="text/javascript" src="${_r.contextPath}/js/main.js"></script>
    
  </head>

  <body>
    [#if _r.user??]
      <!-- Note: "includeFrameContent" is a Snow specific freemarker directive that allow to include the targeted template
        for this URL respecting the "_frame.ftl" hierarchy  -->
      [@includeFrameContent /]
    [#else]
      [@includeTemplate name="loginform.ftl"/] 
    [/#if]
    <footer>${version}</footer>
  </body>
</html>