/*var receipeSubmit = document.getElementById("receipeSubmit");

receipeSubmit.addEventListener("click",function send() {
        var receipe = {
            author: $("#receipeAuthor").val(),
            receipeTitle:$("#receipeTitle").val(),
            receipeDescription:$("#receipeDescription").val(),
			receipeIngredients:$("#receipeIngredients").val(),
			receipePreparation:$("#receipePreparation").val()
        }

        $('#receipeSubmit').html('sending..');

        $.ajax({
            url: '/webapi/v1/receipes',
            type: 'post',
            dataType: 'json',
            success: function (data) {
                $('#receipeSubmit').html(data.msg);
            },
            data: person
        });
    };*/

    var myViewModal = new function() {
    	this.showOne = ko.observable(true),
    	this.showTwo = ko.observable(true),
        this.receipeAuthor = ko.observable("BCS"),
    	showOnlyOne = function(){
    			myViewModal.showOne(true);
    			myViewModal.showTwo(false);
    		},
    	showOnlyTwo = function(){
    			myViewModal.showOne(false);
    			myViewModal.showTwo(true);
    		}
    }
    ko.applyBindings(myViewModal);