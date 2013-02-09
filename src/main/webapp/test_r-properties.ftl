<section id="indexPage" class="content">
  <h1>Freemarker default <em>_r.*</em> properties </h1>
  <div><em>[#noparse]${_r.contextPath}[/#noparse]</em>: "${_r.contextPath}"</div>
  <div><em>[#noparse]${_r.fullPath}[/#noparse]</em>: "${_r.fullPath}"</div>
  <div><em>[#noparse]${_r.href}[/#noparse]</em>: "${_r.href}"</div>
  <div><em>[#noparse]${_r.pathInfo}[/#noparse]</em>: "${_r.pathInfo}"</div>
  <div><em>[#noparse]${_r.user}[/#noparse]</em>: "${_r.user!'no user'}"</div>
  <div><em>[#noparse]${_r.param.param1}[/#noparse]</em>: "${_r.param.param1!'no param1'}"</div>
  <div><em>[#noparse]${_r.req.getHeader("host")}[/#noparse]</em>: "${_r.req.getHeader("host")}" (_r.req is the HttpServletRequest)</div>
</section>