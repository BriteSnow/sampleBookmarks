[@includeTemplate name="navbar.ftl" /]
<section class="content">
  <h4>Add Bookmark</h4>
  <form  id="from-user-create-item" action="${_r.contextPath}/api/user-create-item" method="post">
      <div class="control-group">
        <div class="controls  row-fluid">
          <input class="span6" type="text" name="title" placeholder="title"> <input class="span6" style="margin-left:1.3%" type="text" name="url" placeholder="url">
        </div>
        <div class="controls  row-fluid">
          <textarea   class="span12"  name="note" placeholder="note"></textarea>
        </div>
        <div class="controls clearfix">
          <span id="add-bookmark-error" class="help-inline error"></span><button class="btn btn-primary" type="submit">Add Bookmark</button>
        </div>
      </div>      
  </form>
  
  <script type="text/javascript">
    // Add a bookmark code
    // Use the jquery form plugin, to ajax enable this create bookmark form.
    // Just refresh the page on success
    $(function(){
      var $form = $("#from-user-create-item");
      $form.ajaxForm({
        dataType: "json",
        success: function(data){
          if (data.success){
            // this is a page refresh sample, so, just refresh the page.
            window.location = window.location.href;
          }else{
            var msg = data.errorMessage || data.errorCode || "Error while creating bookmark";
            $("#add-bookmark-error").html(msg);
          }
        }
      });
    });
  </script>
  
  
  
  <h4>Bookmarks</h4>
  
  <ul id="itemList1" class="itemList">
    [#list items as item]
      <li data-entity-id="${item.id}">
        <a href="${item.url!'no url'}">${item.title!'no title'}</a>
        <p class="muted">${item.note}</p>
        <i class="icon-remove-sign do-delete"></i>
      </li>
    [/#list]
  </ul>
  
  <script type="text/javascript">
    // Code that delete a bookmark with clicking on the delete icons
    $(function(){
      $("#itemList1").on("click","i.do-delete",function(event){
        var $li = $(event.target).closest("li");
        var itemId = $li.attr("data-entity-id");
        $.ajax("api/user-item-" + itemId,{
                type: "DELETE",
                dataType: "json"
              }
        ).done(function(data){
          window.location = window.location.href;
        }).fail(function(data){
          
        });
      });
    });
  </script>

</section>

<div class="pageNote">
  <p>This page follow a page refresh model, good for SEO, not 
    optimum for smooth transition and animations. Single page with brite.js comming soon.</p>
</div>
  
