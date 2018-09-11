$(document).ready(function() {
 
	// main slider options
	$("#main-slider").owlCarousel({
	  	items: 1,
	  	itemsDesktop : [1199,1],
	    itemsDesktopSmall : [980,1],
	    itemsTablet: [768,1],
	    itemsTabletSmall: false,
	    itemsMobile : [479,1],
	  	autoPlay: false,
	    autoHeight: true,
	  	navigation: true,
	    navigationText : ["<i class='fa fa-chevron-left' aria-hidden='true'></i>","<i class='fa fa-chevron-right' aria-hidden='true'></i>"]
	});

//	var token = $("meta[name='_csrf']").attr("content");
//	var header = $("meta[name='_csrf_header']").attr("content");
//	
//    $('#mytextareaRu').summernote({
//    	height: 200,
//        callbacks : {
//        	onImageUpload: function(files) {	
//				sendFile(files[0],"ru");
//	        }
//        },
//    });
//    
//    function sendFile(file, lang) {
//        data = new FormData();
//        data.append("image", file);
//        
//        $.ajax({
//        	data: data,
//            type: "POST",
//            url: '<c:url value="/dashboard/uploadEditorImage"/>',
//            enctype: 'multipart/form-data',
//            processData: false, 
//            contentType:false,
//           
//			beforeSend: function(xhr) {
//	            xhr.setRequestHeader(header, token);
//	        },
//	        
//            success: function(url) {
//            	purl = '<c:url value="/"/>' + url;
//            	alert(purl);
//            	
//            	if(lang=="ru")
//            		$('#mytextareaRu').summernote('insertImage', purl,'');
//            	else
//            		$('#mytextareaKg').summernote('insertImage', purl,'');
//            },
//            
//			error : function(ts) {
//				alert(ts.responseText);
//			}
//        });
//    }
//    
//    $('#mytextareaKg').summernote({
//    	height: 200,
//        callbacks : {
//        	onImageUpload: function(files) {	
//				sendFile(files[0], "kg");
//	        }
//        },
//    });
	
	//There are code for initializing text editor for admin forms:

	//first text editor(ru)
//	tinymce
//		.init({
//			selector : '#mytextareaRu',
//			menubar: false,
//			convert_urls: false,
//			plugins: [
//			  'advlist autolink lists link image charmap print preview anchor',
//			  'searchreplace visualblocks code fullscreen',
//			  'insertdatetime media table contextmenu paste code'
//			],
//			toolbar : 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
//			content_css: '//www.tinymce.com/css/codepen.min.css',
//		});
//
//	//second text editor(kg)
//	tinymce
//		.init({
//			selector : '#mytextareaKg',
//			menubar: false,
//			convert_urls: false,
//			plugins: [
//			  'advlist autolink lists link image charmap print preview anchor',
//			  'searchreplace visualblocks code fullscreen',
//			  'insertdatetime media table contextmenu paste code'
//			],
//			toolbar : 'undo redo | insert | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image',
//			content_css: '//www.tinymce.com/css/codepen.min.css'
//		});	
//	
});