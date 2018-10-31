/**
 * Created by  X.L on 2018/9/12.
 */
$(function () {
    var shopId = getQueryString("shopId");
    var isEdit = shopId ? true : false ;
    var initUrl = '/First_Test/shopadmin/getshopinitinfo';
    var registerShopUrl = '/First_Test/shopadmin/registershop';
    var shopInfoUrl = '/First_Test/shopadmin/getshopbyid?shopId=' + shopId;
    var editShopUrl = '/First_Test/shopadmin/modifyshop';
    if(!isEdit){
        getShopInitInfo();
    }else{
        getShopInfo(shopId);
    }
    function getShopInfo(shopId) {
        $.getJSON(shopInfoUrl,function (data) {
            if(data.success){
                var shop = data.shop;
                $('#shop_name').val(shop.shopName);
                $('#shop_addr').val(shop.shopAddr);
                $('#shop_phone').val(shop.phone);
                $('#shop_desc').val(shop.shopDesc);
                var shopCategory = '<option data-id="' + shop.shopCategory.shopCategoryId+
                        '" selected>' + shop.shopCategory.shopCategoryName +'</option>';
                var tempAreaHtml = '';
                data.areaList.map(function (item,index) {
                    tempAreaHtml += '<option data-id="' + item.areaId +'">'
                    +item.areaName +'</option>';
                });
                $('#shop_category').html(shopCategory);
                $('#shop_category').attr('disabled','disabled');
                $('#area').html(tempAreaHtml);
                $("#area option[data-id='"+shop.area.areaId+"']").attr('selected',selected);
            }
        })
    }

    function getShopInitInfo() {
        $.getJSON(initUrl,function (data) {
            if(data.success){
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function (item,index) {
                    tempHtml += '<Option data-id="' + item.shopCategoryId + '">'
                        + item.shopCategoryName + '</Option>'
                });
                data.areaList.map(function (item,index) {
                    tempAreaHtml += '<Option data-id="' + item.areaId + '">'
                        + item.areaName + '</Option>'
                });
                $('#shop_category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }
        });
    }

    $('#submit').click(function () {
        var shop = {};
        if(isEdit){
            shop.shopId = shopId;
        }
        shop.shopName = $('#shop_name').val();
        shop.shopAddr =$('#shop_addr').val();
        shop.phone = $('#shop_phone').val();
        shop.shopDesc = $('#shop_desc').val();
        shop.shopCategory = {
            shopCategoryId : $('#shop_category').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        shop.area = {
            areaId:$('#area').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        var shopImg = $('#shop_img')[0].files[0];
        var formData = new FormData();
        formData.append('shopImg',shopImg);
        formData.append('shopStr',JSON.stringify(shop));
        var verifyCodeActual = $('#j_captcha').val();
        if(!verifyCodeActual ){
            $.toast("请输入验证码！");
            return;
        }
        formData.append('verifyCodeActual',verifyCodeActual);
        $.ajax({
            url : (isEdit ? editShopUrl : registerShopUrl),
            type : 'POST',
            data : formData,
            contentType : false,
            processData : false,
            cache : false,
            success : function (data) {
                if(data.success){
                    $.toast("提交成功！");
                }else{
                    $.toast("提交失败！--->"+data.errMsg);
                }
                $('#captcha_img').click();
            }
        });
    });
})
