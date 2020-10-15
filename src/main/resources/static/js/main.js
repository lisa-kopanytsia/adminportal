$(document).ready(function() {
  $('.delete-product').on('click',function () {
    /*<![CDATA[*/
    var path = /*[[@{/}]]*/ 'remove';
    /*]]>*/

    var id=$(this).attr('id');

    bootbox.confirm({
      message: "Вы точно хотите удалить этот товар?",
      buttons: {
        cancel:{
          label:'<i class="fa fa-times"></i> Отменить'
        },
        confirm: {
          label: '<i class="fa fa-check"></i> Подтвердить'
        }
      },
      callback: function (confirmed) {
        if(confirmed){
          $.post(path,{'id':id}, function (res) {
            location.reload();
          });
        }
      }
    });
  });


 // var productIdList=[];

  //$('.checkboxProduct').click(function () {
 //   var id=$(this).attr('id');
//    if(this.checked){
//      productIdList.push(id);
//    }else {
//      productIdList.splice(productIdList.indexOf(id),1);
//    }
 // })

  $('#deleteSelected').click(function () {
    var idList= $('.checkboxProduct');
    var productIdList=[];
    for (var i = 0; i < idList.length; i++) {
      if(idList[i].checked==true) {
        productIdList.push(idList[i]['id'])
      }
    }
    console.log(productIdList);

    /*<![CDATA[*/
    var path = /*[[@{/}]]*/ 'removeList';
    /*]]>*/
    bootbox.confirm({
      message: "Вы точно хотите удалить все отмеченные товары?",
      buttons: {
        cancel:{
          label:'<i class="fa fa-times"></i> Отменить'
        },
        confirm: {
          label: '<i class="fa fa-check"></i> Подтвердить'
        }
      },
      callback: function (confirmed) {
        if(confirmed){
          $.ajax({
            type: 'POST',
            url: path,
            data: JSON.stringify(productIdList),
            contentType: "application/json",
            success: function (res) {console.log(res); location.reload()},
            error: function (res) {console.log(res); location.reload();}
          });
        }
      }
    });
  });

  $("#selectAllProduct").click(function () {
    if ($(this).prop("checked") == true) {
      $(".checkboxProduct").prop("checked", true);
    } else if ($(this).prop("checked") == false) {
      $(".checkboxProduct").prop("checked", false);
    }
  })
});