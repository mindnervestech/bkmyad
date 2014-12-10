angular.module('adschela').controller("Booknewspaperaddonline",['$scope','beData',function($scope,beData){
	$scope.forTest = beData;
}]);

angular.module('adschela').controller("HeaderController",['$scope',function($scope){
}]);

angular.module('adschela').controller("FooterController",['$scope',function($scope){
}]);

angular.module('adschela').controller("IndexController",['$scope','$http','$cookieStore','$cookies','$interval',function($scope,$http,$cookieStore,$interval,$cookies){
	$scope.showFieldError = false;
	    $scope.showError = false;
	$scope.onClassifiedClicked = function(){
		console.log("onClassifiedClicked");
		 $('#classifiedUserInfo').modal();
	}
	$scope.footerCheck();
		
	
	$scope.imgageHeight = $scope.imgageHeight;
	if( $scope.imgageHeight != "" ||angular.isUndefined($scope.imgageHeight)){
	document.getElementById("imagetag").style.marginRight = 30 +"%" ;
	}else{
		document.getElementById("imagetag").style.marginRight = 20 +"%" ;
	}
	    /*$scope.setCookie();
	    if($scope.cookie ==  '' || (angular.isUndefined($scope.cookie))){
			 $('#userInfopopup').modal();
	    }*/
	    
	    $scope.sendMailAboutClassifiedAd = function(tempuserName,tempuserMobnumber,tempuserNote){
	    	
	    	$scope.tempuserName = tempuserName;
			$scope.tempuserMobnumber = tempuserMobnumber;
	    	$scope.tempuserNote = tempuserNote;
	    	if($scope.tempuserName == "" || $scope.tempuserMobnumber == "" || (angular.isUndefined($scope.tempuserMobnumber))|| (angular.isUndefined($scope.tempuserName))){
	    		$scope.showFieldError = true; 
	    	}
	    	console.log("$scope.tempuserName"+$scope.tempuserName);
	    	
	    	document.getElementById("myDiv").style.marginRight = 50 +'%';
			/*if($scope.tempuserNote == "" || (angular.isUndefined($scope.tempuserNote))){
				$scope.tempuserNote ="Not Given";
			}*/
			if((!angular.isUndefined($scope.tempuserMobnumber))|| (!angular.isUndefined($scope.tempuserName))||(!angular.isUndefined($scope.tempuserNote)) ){
		    { $scope.showFieldError = false;
		    	$('#classifiedUserInfo').modal('hide');
		   // $('#classifiedUserInfo').modal();
			$http.get('sendMailAboutClassifiedAd/'+$scope.tempuserName+'/'+$scope.tempuserMobnumber+'/'+$scope.tempuserNote)
			.success(function(data){
				if(data) {
					$scope.result = data;
					if($scope.result == 'success'){
						console.log($scope.result);
						}
					
				} 
			});
		    }
	    }
	    }
	    $scope.sendMailAboutGuestuser =  function(tempuserName,tempuserMobnumber){
		$scope.tempuserName = tempuserName;
		$scope.tempuserMobnumber = tempuserMobnumber;
		
		if((angular.isUndefined($scope.tempuserMobnumber))|| (angular.isUndefined($scope.tempuserName))){
		     $scope.showError = true;
		}		
		if((!angular.isUndefined($scope.tempuserMobnumber))|| (!angular.isUndefined($scope.tempuserName))){
			$('#userInfopopup').modal('hide');		
			$scope.showError = false;
			$scope.setCookie();
			
			$http.get('sendMailAboutTempUserInfo/'+$scope.tempuserName+'/'+$scope.tempuserMobnumber)
			.success(function(data){
				if(data) {
					$scope.result = data;
					if($scope.result == 'success'){
						
						}
					
				} 
			});
			
		}
	    }
	$scope.txtpasswords = 'password';
	$scope.nplist = [
	                 {name:"Times of India",img:"/NewDesign/np-logos/toi.jpg"},
	                 {name:"Hindustan Times",img:"/NewDesign/np-logos/hindustantimes.jpg"},
	                 {name:"The Hindu",img:"/NewDesign/np-logos/Hindu.png"},
	                 {name:"Daily Thanthi",img:"/NewDesign/np-logos/Daily Thanthi.jpg"},
	                 {name:"Amar Ujala",img:"/NewDesign/np-logos/amarujala.jpg"},
	                 {name:"Danik Jagaran",img:"/NewDesign/np-logos/dainikjagaran.png"},
	                 {name:"The-Telegraph",img:"/NewDesign/np-logos/The-Telegraph.png"},
	                 {name:"Hindustan",img:"/NewDesign/np-logos/hindustan.jpg"},
	                 {name:"Sandhya Times",img:"/NewDesign/np-logos/sandhyatimes.jpg"},
	                 {name:"Maharashtra Times",img:"/NewDesign/np-logos/maharashtratimes.jpg"},
	                 {name:"Vijay Karnataka",img:"/NewDesign/np-logos/vijaykarnataka.jpg"},
	              /*   {name:"Times of India",img:"/NewDesign/np-logos/toi.jpg"},*/
	                 {name:"Economic Times",img:"/NewDesign/np-logos/The-Economic-Times.png"},
	                 /*{name:"The Hindu",img:"/NewDesign/np-logos/Hindu.png"},*/
	                 {name:"Mirror",img:"/NewDesign/np-logos/Mirror.jpg"},
	                 {name:"Deccan Herald",img:"/NewDesign/np-logos/Deccan-Herald.png"},
	               /*  {name:"Navbharat Times",img:"/NewDesign/np-logos/navbharattimes.jpg"},*/
	                 {name:"Rajasthan Patrika",img:"/NewDesign/np-logos/rajasthanpatrika.jpg"},
	                 {name:"Prajavani",img:"/NewDesign/np-logos/prajavani.jpg"},
	                 {name:"udyavani-head",img:"/NewDesign/np-logos/udyavani-head.jpg"},
/*	                 {name:"Kashmir Times",img:"/NewDesign/np-logos/Kashmir Times Logo.jpg"},
	                 {name:"Dainik Sambad",img:"/NewDesign/np-logos/dainik sambad.jpg"},
	                 {name:"Prothom alo",img:"/NewDesign/np-logos/prothom alo logo.jpg"},
	                 {name:"Inquilab",img:"/NewDesign/np-logos/Inquilab logo.jpg"},
	                 {name:"ABP",img:"/NewDesign/np-logos/ABP.png"},
*/	                 {name:"Deccan Chronicle",img:"/NewDesign/np-logos/deccanchronicle.jpg"},
	                 {name:"Assam Tribune",img:"/NewDesign/np-logos/assamtribune.jpg"},
	                 {name:"Daily Excelsior",img:"/NewDesign/np-logos/dailyexcelsior.jpg"},
	                 /*{name:"Daily Star",img:"/NewDesign/np-logos/dailystar.jpg"},
	                 */
	                 {name:"Dainikbhaskar",img:"/NewDesign/np-logos/dainikbhaskar.jpg"},
	                 /*{name:"Dainikjugasankha",img:"/NewDesign/np-logos/dainikjugasankha.jpg"},
	                 {name:"Dharitri",img:"/NewDesign/np-logos/dharitri.jpg"},
	                 */
	                 {name:"Dinakaran",img:"/NewDesign/np-logos/dinakaran.jpg"},
	                 {name:"Dinamalar",img:"/NewDesign/np-logos/dinamalar.jpg"},
	                 {name:"Dinamani",img:"/NewDesign/np-logos/dinamani.jpg"},
	                 {name:"Divyabhaskar",img:"/NewDesign/np-logos/divyabhaskar.jpg"},
	                 {name:"DNA.jpg",img:"/NewDesign/np-logos/dna.jpg"},
	             /*    {name:"Easternchronicle",img:"/NewDesign/np-logos/easternchronicle.jpg"},*/
	                 {name:"Eenadu",img:"/NewDesign/np-logos/eenadu.jpg"},
	               /*  {name:"Ekdin",img:"/NewDesign/np-logos/ekdin.jpg"},*/
	                /* {name:"Goa Messenger",img:"/NewDesign/np-logos/goamessenger.jpg"},
	                 {name:"Himalibela",img:"/NewDesign/np-logos/himalibela.jpg"},
	                 {name:"Janpath Samachar",img:"/NewDesign/np-logos/janpathsamachar.jpg"},
	                 {name:"Jugantor",img:"/NewDesign/np-logos/jugantor.jpg"},
	                 {name:"kannadaprabha",img:"/NewDesign/np-logos/kannadaprabha.jpg"},
	                 {name:"lokprabha",img:"/NewDesign/np-logos/lokprabha.jpg"},
	                 {name:"Lokmat",img:"/NewDesign/np-logos/Lokmat.jpg"},
	                */ 
	                 {name:"Ajit",img:"/NewDesign/np-logos/ajit.png"},	                 	                 
/*	                 {name:"Dainik-Kashmir-Times",img:"/NewDesign/np-logos/dainik-kashmir-times.png"},
*/	                 {name:"Gujarat Samachar",img:"/NewDesign/np-logos/gs-log-big.png"},
	               /*  {name:"Sanmagra",img:"/NewDesign/np-logos/image.gif"},*/
	                 {name:"Divya Marathi",img:"/NewDesign/np-logos/image.jpg"},
	                 {name:"Malayalamanorama",img:"/NewDesign/np-logos/malayalamanorama.jpg"},
	                 {name:"Mathrubhumi",img:"/NewDesign/np-logos/mathrubhumi.jpg"},
	                 {name:"Midday",img:"/NewDesign/np-logos/midday.jpg"},
	                 {name:"Naiduniaepaper",img:"/NewDesign/np-logos/naiduniaepaper.jpg"},
/*	                 {name:"Prothom alo",img:"/NewDesign/np-logos/prothom alo logo.jpg"},
*/	                 {name:"Punjab Kesri",img:"/NewDesign/np-logos/punjabkesri.jpg"},
	                 {name:"Punyanagari-Big",img:"/NewDesign/np-logos/punyanagari-big.png"},
	                 {name:"Sakal",img:"/NewDesign/np-logos/sakal.jpg"},
	                 {name:"Sakshi",img:"/NewDesign/np-logos/sakshi.jpg"},
	                 {name:"Sambad",img:"/NewDesign/np-logos/sambad.jpg"},
	                 {name:"Sandesh",img:"/NewDesign/np-logos/sandesh.jpg"},
	                 {name:"Sandhyatimes",img:"/NewDesign/np-logos/sandhyatimes.jpg"},
	                 {name:"Thenewindianexpress",img:"/NewDesign/np-logos/thenewindianexpress.jpg"},	                 	                 
	                 {name:"The-Samaj",img:"/NewDesign/np-logos/The-Samaj.png"},
	                 {name:"Thesiasatdaily",img:"/NewDesign/np-logos/thesiasatdaily.jpg"},
	                 {name:"Thestatesman",img:"/NewDesign/np-logos/thestatesman.jpg"},
	                 
	                 {name:"The-Tribune",img:"/NewDesign/np-logos/The-Tribune.png"},
	                /* {name:"Navbharat",img:"/NewDesign/np-logos/Navbharat.jpg"},*/
	                 {name:"Navbharattimes",img:"/NewDesign/np-logos/navbharattimes.jpg"},
	                 {name:"Newbline",img:"/NewDesign/np-logos/newbline.png"},	                 	                 
	                 {name:"Prabhatkhabar",img:"/NewDesign/np-logos/prabhatkhabar.jpg"}];
	
	$scope.carousel= {
			interval : 6000
	}
    $scope.slides = [{
	      	image: '/NewDesign/homepagesImages/CT 1.jpg'
	    	}
	    	/*{
		      image: '/NewDesign/images/classified-ad-2.jpg'
		    },
		    {
			      image: '/NewDesign/images/all-np-2.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-3.jpg'
			},
		    {
			      image: '/NewDesign/images/all-np-3.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-4.jpg'
			},*/
		   /* {
			      image: '/NewDesign/images/banner11.jpg'
			}*/
		    ];
	
	
	 $scope.dispAds = [{
	      	image: '/NewDesign/homepagesImages/Ds 1.jpg'
	    	}
	    	/*{
		      image: '/NewDesign/images/classified-ad-2.jpg'
		    },
		    {
			      image: '/NewDesign/images/all-np-2.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-3.jpg'
			},
		    {
			      image: '/NewDesign/images/all-np-3.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-4.jpg'
			},*/
		   /* {
			      image: '/NewDesign/images/banner11.jpg'
			}*/
		    ];
	 $scope.clasifiedsImages = [{
	      	image: '/NewDesign/homepagesImages/CD 1.jpg'
	    	}
		    
	    	/*{
		      image: '/NewDesign/images/classified-ad-2.jpg'
		    },
		    {
			      image: '/NewDesign/images/all-np-2.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-3.jpg'
			},
		    {
			      image: '/NewDesign/images/all-np-3.jpg'
			},
		    {
			      image: '/NewDesign/images/classified-ad-4.jpg'
			},*/
		    /*{
			      image: '/NewDesign/images/banner11.jpg'
			}*/
		    ];
	  
}]);
angular.module('adschela').controller("AboutUsController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("ContactUsController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("OurClientController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("OurServicesController",['$scope',function($scope){
	
}]);angular.module('adschela').controller("TermsandConditionsController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("PrivacyPolicyController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("PaymentoptionController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("DisclaimerController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("HelpController",['$scope',function($scope){
	
}]);

angular.module('adschela').controller("ComposeDisplayAdController",['$scope','$upload','$timeout',function($scope,$upload,$timeout,$modal, $http, $filter){
	//make the color display ad visible default  disable the B/W ad.
	$scope.defaultWidth = true;
	$scope.otherWidth = false;
	/*$scope.preViewColorAd = function(){
		preViewColorAd($scope);
	}*/
	
	
	$scope.preViewColorAd = function() {
		$('#adColorPreview').modal();
	}
	
	$scope.selectDefaultWidth = function(){
		$scope.otherWidth = false;
	    $scope.selectedCartItemOnPopUp.defaultWidth = "3"
	    console.log("$scope.selectedCartItemOnPopUp.defaultWidth"+$scope.selectedCartItemOnPopUp.defaultWidth);
	}
	
	$scope.onBackButtonClicked = function(){
		 if($scope.uploadyourAdSelect == "userType"){
			   $scope.rc.composeWizard.moveTo(0);
		   }else{
			   $scope.rc.composeWizard.backward();
		   }
	}

	$scope.file ='';
	$scope.selectedFiles = [];
							$scope.selectGeneralPicImage = function($files) {
								file = $files[0];
								/* generalPic = $generalPic[0]; */
								if ($scope.selectedFiles.length == 0) {
									$scope.tempSelectedFiles = [];
								}
								$scope.selectedFiles.push($files);
								$scope.tempSelectedFiles.push($files);
							    $scope.file = $files[0];
								var $previewImage = $files[0];
							    var fileSize = $previewImage.size; // size in kb
								console.log(fileSize);
								fileSize = fileSize / 1048576; // size in mb
								console.log(fileSize);
								if (fileSize > 0.5) {
									$scope.isSuccess = true;
									// file = null;
								}
								if (window.FileReader
										&& $previewImage.type.indexOf('image') > -1) {
									var fileReader = new FileReader();
									fileReader.readAsDataURL($files[0]);
									var loadFile = function(fileReader, index) {
										fileReader.onload = function(e) {
											$timeout(function() {
												$scope.img = e.target.result;
												/*$scope.dataUrls
														.push(e.target.result);*/
											});
										}
									}(fileReader, 0);

								}
							};

	
	$scope.savegeneralPic = function(){	
	    	//$scope.savegeneral.supplierCode = supplierCode;
	  	   $scope.upload = $upload.upload({
	             url: '/savegeneralImg', 
	             method:'post',
	             fileFormDataName: 'file',
	             file:file,
	            
	     }).progress(function(evt) {
	             console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
	     }).success(function(data, status, headers, config) {
	    	 console.log(data);   
	    	 console.log(data);
	            $scope.imgpathretrived = data;
	           //console.log("img"+ $scope.img);
	           
	     }); 
	  	 
	     }
	
	$scope.showColorAd = true;
	$scope.colorAd = "colorAd";
	$scope.showBWAd = false;
	$scope.text = " ";
	$scope.total_unit = " ";
	
	$scope.flag = false;
	$scope.selectedCartItemOnPopUp = GetSelectedCartItemOnPopUp();
	var borderSelected;
	var totalCost;
	var borderColor;
	var backgroundColor;
	var borderColorInPer;
	var backgroundColorInPer;
	var extracostFortick;
	var extracostFortickInPer;
	var rate;
	var checkColorSelected;
	var savenameofcolorSelected;
	var extracostFortick;
    var bgColorSelected = $scope.selectedCartItemOnPopUp.onbgColorchange;
	borderColor = parseInt($scope.selectedCartItemOnPopUp.extraForBorder);
	backgroundColor = parseInt($scope.selectedCartItemOnPopUp.extraForBackgroud);
	extracostFortick =  parseInt($scope.selectedCartItemOnPopUp.extraFortick);
	borderColorInPer = parseInt($scope.selectedCartItemOnPopUp.extraForBorderInPer);
	backgroundColorInPer = parseInt($scope.selectedCartItemOnPopUp.extraForBackgroudInPer);
	extracostFortickInPer =  parseInt($scope.selectedCartItemOnPopUp.extraFortickInPer);
	
	/*if ($scope.selectedCartItemOnPopUp.onBorderSelected == null || $scope.selectedCartItemOnPopUp.onBorderSelected == '') {
		$scope.selectedCartItemOnPopUp.onBorderSelected='No';
	}*/
	$scope.descFocusOut = function(event) {
		console.log(event);
	}
	/*
	$scope.onBorderselected = function(){
		if($scope.selectedCartItemOnPopUp.onBorderSelected == 'Yes') {
			upRate(borderColor,borderColorInPer);
		} else {
			downRate(borderColor,borderColorInPer);
		}
		ReTotal();
	}*/
	/*$scope.selectedCartItemOnPopUp.notickforAd=$scope.selectedCartItemOnPopUp.notickforAd;
	$scope.onNoTickSelected = function(){
		
		if($scope.selectedCartItemOnPopUp.notickforAd){
			downRate(extracostFortick,extracostFortickInPer);
		}
		else{
			upRate(extracostFortick,extracostFortickInPer);
		}
		ReTotal();
	}
	*/
	/*$scope.onNoBgcolorSelected=function(){
		  if($scope.selectedCartItemOnPopUp.nobgColor) { 
			  downRate(backgroundColor, backgroundColorInPer); 
			 $scope.selectedCartItemOnPopUp.onbgColorchange='No';
		  }
		  else {
			  upRate(backgroundColor, backgroundColorInPer) 
			  $scope.selectedCartItemOnPopUp.onbgColorchange='lemonchiffons';
		  }
		
		  ReTotal(); 
	}*/
	
	/*function downRate(inValue, inPer) {
		if(inValue != 0) {
			 $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - inValue;
		 } else if (inPer != 0){
			 $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - $scope.selectedCartItemOnPopUp.totalUnitCost * ((inPer)/(100));
		 } 
	}
	
	function upRate(inValue, inPer) {
		
		if(inValue != 0) {
			  $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + inValue;
		} else if (inPer != 0){
			  $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + $scope.selectedCartItemOnPopUp.totalUnitCost * ((inPer)/(100));
		} 
	}*/
	
	$scope.a=false ;
	$('body').on('blur','#translationArea',function(e) {
		console.log("capture focus out area... ");
		computeRateByUnit();
	});
	$scope.selectedCartItemOnPopUp.isHindi=false;
	$scope.transliterateDone = function(data) {
		console.log("$scope.selectedCartItemOnPopUp.isHindi " + $scope.selectedCartItemOnPopUp.isHindi);
		console.log(data);
		if($scope.selectedCartItemOnPopUp.isHindi) {
			$scope.$apply(function() {
				var tokens = $scope.selectedCartItemOnPopUp.description.split(" ");
				$scope.selectedCartItemOnPopUp.description = "";
				for(var i=0; i<tokens.length-1;i++) {
					$scope.selectedCartItemOnPopUp.description = $scope.selectedCartItemOnPopUp.description + tokens[i] + " ";	
				}
				$scope.selectedCartItemOnPopUp.description = $scope.selectedCartItemOnPopUp.description + data + " ";
			});
		}
		computeRateByUnit();
	};
	
	$scope.isEmptyOrBlank = function(str) {
		if (angular.isUndefined(str) || str == null || str == '') {
			return false;
		}  
		return true;

	};
	
	
	
	function countWords(){
		s = $scope.selectedCartItemOnPopUp.description;
		s = s.replace(/(^\s*)|(\s*$)/gi,"");
		s = s.replace(/[ ]{2,}/gi," ");
		s = s.replace(/\n /,"\n");
		s = s.replace('@',"@ ");
		s = s.replace('-',"- ");
		s = s.replace('.',". ");
		s = s.replace(',',", ");
		s = s.replace('/',"/ ");
		s = s.replace('\\'," \\ ");
		return s.split(' ').length;
	}
	
	
	 	function computeRateByUnit() {
		console.log("calculating count.");
		dTotalPrice = parseInt($scope.selectedCartItemOnPopUp.dTotalPrice);
		rate = parseInt($scope.selectedCartItemOnPopUp.rate); //base rate for ad.
		var freeUnit = parseInt($scope.selectedCartItemOnPopUp.freeUnit); //total allowed free units.
        var unitLot = parseInt($scope.selectedCartItemOnPopUp.unitVal); //???
        var text = $('#adPreview').text().trim();
        /*if($scope.uploadyourAdSelect == "userType"){
	    	text = "User Uploaded Ad";
	    	var height = parseInt($scope.selectedCartItemOnPopUp.height);
        	console.log("height"+height);
        	var width = parseInt($scope.selectedCartItemOnPopUp.otherWidth);
        	console.log("width"+width);
        	totalCost = rate * width * height;
        	//console.log(totalCost);
	    }*/
        
        //text = "sbcd";
        console.log(text);
        console.log("text in compute rate"+text.length);
            if (text != '') {
            	$scope.selectedCartItemOnPopUp.description = text; 
                var total_unit;
                var extraUnit;
                if ($scope.selectedCartItemOnPopUp.unit == "Words") {
                	console.log("counting words");
                	total_unit =  countWords(text);
                } else {
                	if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                		text = $('#descriptionHeaderText').text().trim()+""+$('#descriptionBodyText').text().trim() +""+$('#descriptionFooterText').text().trim();
                		console.log(text);
                		var replaced = text.replace(/ /g, '');
                		replaced = replaced.trim();
                		console.log(replaced.length);
                		total_unit = Math.ceil(replaced.length / 22);
                    }
                }
                
                if($scope.uploadyourAdSelect == "userType"){
         	    	//text = "User Uploaded Ad";
                	$scope.selectedCartItemOnPopUp.otherWidth = "4";
                	console.log("in user type")
            		var height = parseInt($scope.selectedCartItemOnPopUp.height);
            		console.log(height);
                 	var width = parseInt($scope.selectedCartItemOnPopUp.otherWidth);
                 	totalCost = rate * width * height;
                 	console.log(totalCost);
         	    }else if ($scope.uploadyourAd == 'templateSelect'){
         	    	$scope.selectedCartItemOnPopUp.otherWidth = "4";
         	    	var  width = parseInt($scope.selectedCartItemOnPopUp.otherWidth);
         	    	$scope.selectedCartItemOnPopUp.height =  (($("#adPreview").get(0).scrollHeight)/37.795276);
         	    	var  height = parseInt($scope.selectedCartItemOnPopUp.height);
                 	console.log("height"+height);
                   //var width = parseInt($scope.width);
                 	console.log("width"+width);
         	    	totalCost = rate * height * width ;	
         	    }
                
                /*          if (total_unit > freeUnit) {
                   //var extraUnitCost = $scope.selectedCartItemOnPopUp.extra;
                   var costt = parseInt($scope.selectedCartItemOnPopUp.extra);
                   extraUnit = total_unit - freeUnit;
                   if(unitLot > 0){
                     totalCost = rate + (costt * (extraUnit/unitLot));
                   }
                   else{
                   console.log("unitLot " + unitLot)
                   totalCost = rate + (costt * extraUnit);
                   }
                }
                else {
                	//totalCost = rate;	
                	console.log("in totle cost"+totalCost);
                	 if($scope.uploadyourAdSelect == "userType"){
             	    	//text = "User Uploaded Ad";
                		$scope.height = parseInt($scope.selectedCartItemOnPopUp.height);
                     	console.log("height"+height);
                     	$scope.width = parseInt($scope.selectedCartItemOnPopUp.otherWidth);
                     	console.log("width"+width);
                     	totalCost = rate * width * height;
                     	console.log(totalCost);
             	    }else if ($scope.uploadyourAd == 'templateSelect'){
             	        $scope.width = "4";
             	    	$scope.height = parseInt($scope.height);
                     	console.log("height"+height);
                     	
                     	$scope.width = parseInt($scope.width);
                     	console.log("width"+width);
             	    	totalCost = rate * height * width ;	
             	    }
                }*/
              /*  if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                	total_unit = Math.ceil(text.length / 23);
                }*/
              $scope.$apply(function(){
                	$scope.selectedCartItemOnPopUp.totalUnit = total_unit;
                	$scope.selectedCartItemOnPopUp.extraCost = totalCost - rate;
                	$scope.selectedCartItemOnPopUp.totalUnitCost = totalCost;
                	$scope.selectedCartItemOnPopUp.extraUnit = extraUnit;
                	ReTotal();
              });
               
            }
            console.log($scope.selectedCartItemOnPopUp);
	}
	$scope.formatDate = function(cd) {
		return moment(cd).format('DD/MM/YYYY');
	}
	
	//select the firstColumn (Ad(3*5)) default.
	$scope.firstColumn = "firstColumn";
	//hide and show the ad types
    $scope.onColorAdChoose = function(colorAd){
		console.log("in hide and show");
		console.log("bwAd selectedCartItemOnPopUp.colorAd: "+colorAd);
		$scope.selectedCartItemOnPopUp.colorAd = colorAd;
		$scope.colorAd = colorAd;
		$scope.showColorAd = true;
		$scope.showBWAd = false;
		computeRateByUnit();
	   // upRate(backgroundColor, backgroundColorInPer)
		ReTotal();
	}

     // if firstTime (Fresh order ) is placing the user
    // uprate default if select ad is Color ad
    if(angular.isUndefined($scope.selectedCartItemOnPopUp.colorAd) || $scope.selectedCartItemOnPopUp.colorAd == ""){
    	$scope.selectedCartItemOnPopUp.colorAd = "colorAd";
    	 computeRateByUnit();
    //	 upRate(backgroundColor, backgroundColorInPer)
		 ReTotal();
    }
   
    if($scope.selectedCartItemOnPopUp.colorAd == "BWAd"){
    	$scope.showBWAd = true;
    	$scope.showColorAd = false;
    }
   
  //default set the 3(header body footer) (new order ) is placing user.
    if(angular.isUndefined($scope.selectedCartItemOnPopUp.imageAd) || $scope.selectedCartItemOnPopUp.imageAd == ""){
		$scope.selectedCartItemOnPopUp.imageAd = "3";
		console.log("$scope.selectedCartItemOnPopUp.imageAd:"+$scope.selectedCartItemOnPopUp.imageAd);
		
    }
    
    //black and white ad clicked
    $scope.onBWAdChoose = function(bwAd){
    	$scope.colorAd = bwAd;
		$scope.showColorAd = false;
		$scope.showBWAd = true;
	     computeRateByUnit();
	      //downRate(backgroundColor, backgroundColorInPer)
		ReTotal();
    }
    
	// on select image for ad   
	$scope.onSelectImageforAd = function(selectImageForAdId){
		$scope.imageAd = $scope.selectedCartItemOnPopUp.imageAd;
	}
	
	//on compose ad display all done.
	$scope.onComposeDisplayAdDone = function(){
		SaveToCart($scope.selectedCartItemOnPopUp);
		console.log("onComposeDisplayAdDone");
		if($scope.selectedCartItemOnPopUp.dates == ""){
			alert("Please select date");
			}
		else{ //used to close the opened Dialog
			  closeDialog();
			}
	}
	
	//on header color change
	$scope.onColorHeaderChange = function(){
		$scope.headerColor=	$scope.selectedCartItemOnPopUp.headerColor;
	}

	$scope.onColorBodyChange = function(){
		console.log("$scope.selectedCartItemOnPopUp.colorBody"+$scope.selectedCartItemOnPopUp.colorBody);
		$scope.bodyColor = $scope.selectedCartItemOnPopUp.bodyColor;
	}  
	
	
	$scope.onColorFooterChange = function(){
		console.log($scope.selectedCartItemOnPopUp.footerColor);
		$scope.footerColor = $scope.selectedCartItemOnPopUp.footerColor;
		//console.log("$scope.footerColor"+$scope.footerColor);
	}
	//on next clicked on the composeaddisplay popup  ad controller 
	$scope.onComposeDisplayAdStepChange = function(){
		 //InitDatepicker();
		// $scope.rc.composeWizard.forward();
	   if($scope.uploadyourAdSelect == "userType"){
    		 InitDatepicker();
			 computeRateByUnit();
			 $scope.rc.composeWizard.moveTo(2);
	   }else{
		   	$scope.rc.composeWizard.forward();
	   }
			if(angular.isUndefined($scope.selectedCartItemOnPopUp.adSizeSelect) || $scope.selectedCartItemOnPopUp.adSizeSelect == "firstColumn"){
			$scope.selectedCartItemOnPopUp.adSizeSelect = "firstColumn";
			document.getElementById('adPreview').style.width = 4 + 'cm';
			document.getElementById('adPreview').style.height = 188.97 + 'px';
		}else{
			$scope.selectedCartItemOnPopUp.adSizeSelect = "secondColumn";
			document.getElementById('adPreview').style.width = 4 + 'cm';
			document.getElementById('adPreview').style.height = 188.97 + 'px';
		}
		//console.log("adSelect Size:"$scope.selectedCartItemOnPopUp.adSizeSelect);
		$scope.descriptionHeader = false;
		$scope.descriptionBody = false;
		$scope.descriptionFooter = false;
		//disable all textArea Box initially
		$scope.descriptionHeaderText = false;
		$scope.descriptionBodyText = false;
		$scope.descriptionFooterText = false;
		//hide color box
		$scope.headerColor = false;
		$scope.footerColor = false;
		$scope.bodyColor  = false;
	    //console.log("selectImageForAdId"+selectImageForAdId);
		//Enable only the body,footer TextEditor
		if($scope.selectedCartItemOnPopUp.imageAd == 1){
			$scope.showImagePreview = false; 
			$scope.descriptionBody = true;
			$scope.showImageUploadOption = false;
			$scope.descriptionFooter = true;
			$scope.descriptionBodyText = true;
			$scope.descriptionFooterText = true;
			$scope.imageId = $scope.selectedCartItemOnPopUp.imageAd;
			$scope.selectUrlForAdStore($scope.imageId);
			if($scope.rc.composeWizard.currentIndex  == 2){
			if ($scope.selectedCartItemOnPopUp.descriptionHeader == "" || $scope.selectedCartItemOnPopUp.descriptionBody == ""){
				//alert("Please Fill all ad details");
				$scope.checkAllAdField();
			}	
			}
			//assign the text to adPreview
    		document.getElementById('descriptionBodyText').innerHTML = tinyMCE.get('tinymceBody').getContent();
    		document.getElementById('descriptionFooterText').innerHTML = tinyMCE.get('tinymceFooter').getContent();
			//show color box
			if($scope.selectedCartItemOnPopUp.colorAd == "colorAd"){
			$scope.footerColor = true;
			$scope.bodyColor = true;
			}
		}else if($scope.selectedCartItemOnPopUp.imageAd == 2){
			//Enable only the body,Header TextEditor
			$scope.showImagePreview = false; 
			$scope.showImageUploadOption = false;
			$scope.descriptionHeader = true;
			$scope.descriptionBody = true;
			$scope.descriptionHeaderText = true;
			$scope.descriptionBodyText = true;
			$scope.imageId = $scope.selectedCartItemOnPopUp.imageAd;
			$scope.selectUrlForAdStore($scope.imageId);
			//assign header and body text Ad preview
			if($scope.rc.composeWizard.currentIndex == 2){
			if ($scope.selectedCartItemOnPopUp.descriptionBody == "" || $scope.selectedCartItemOnPopUp.descriptionFooter == "" ){
						//alert("please fill all add details")
						$scope.checkAllAdField();
					}    		
			}
			document.getElementById('descriptionHeaderText').innerHTML = tinyMCE.activeEditor.getContent();
			document.getElementById('descriptionBodyText').innerHTML = tinyMCE.get('tinymceBody').getContent();
    	//	document.getElementById('descriptionFooterText').innerHTML = tinyMCE.get('tinymceFooter').getContent();
			
			if($scope.selectedCartItemOnPopUp.colorAd == "colorAd"){
			$scope.headerColor = true;
			$scope.bodyColor  = true;
			}
			
		}else if($scope.selectedCartItemOnPopUp.imageAd == 3){
			//Enable All TextEditor
			$scope.showImagePreview = false; 
			$scope.showImageUploadOption = false;
			console.log("$scope.selectedCartItemOnPopUp.imageAd"+$scope.selectedCartItemOnPopUp.imageAd);
			$scope.descriptionHeader = true;
			$scope.descriptionBody = true;
			$scope.descriptionFooter = true;
			$scope.imageId = $scope.selectedCartItemOnPopUp.imageAd;
			$scope.selectUrlForAdStore($scope.imageId);
			console.log($scope.selectedCartItemOnPopUp.description);
			$scope.descriptionHeaderText = true;
			$scope.descriptionBodyText = true;
			$scope.descriptionFooterText = true;
			// display the a;; section of adPreview
			document.getElementById('descriptionHeaderText').innerHTML = tinyMCE.activeEditor.getContent();
    		document.getElementById('descriptionBodyText').innerHTML = tinyMCE.get('tinymceBody').getContent();
    		document.getElementById('descriptionFooterText').innerHTML = tinyMCE.get('tinymceFooter').getContent();
    		
    		if($scope.rc.composeWizard.currentIndex   == 1){
    		if ( tinyMCE.activeEditor.getContent() == "" ||
    				tinyMCE.get('tinymceBody').getContent() == "" ||
    				tinyMCE.get('tinymceFooter').getContent() == "" ){
    			    //alert("Please fill all Ad details");
    			     //used to move to step(1) current step
    			  //  $scope.checkAllAdField();
    		}
    		}
    		if($scope.selectedCartItemOnPopUp.colorAd == "colorAd"){
			$scope.footerColor = true;
			$scope.headerColor = true;
			$scope.bodyColor  = true;
			}
		}else if($scope.selectedCartItemOnPopUp.imageAd == 4){
			//Enable only the body,footer
			$scope.showImagePreview = false; 
			$scope.showImageUploadOption = false;
			$scope.descriptionBody = true;
			$scope.descriptionFooter = true;
			$scope.descriptionBodyText = true;
			$scope.descriptionFooterText = true;
			$scope.imageId = $scope.selectedCartItemOnPopUp.imageAd;
			$scope.selectUrlForAdStore($scope.imageId);
           // Add the Body section 
    		document.getElementById('descriptionBodyText').innerHTML = tinyMCE.get('tinymceBody').getContent();
    		document.getElementById('descriptionFooterText').innerHTML = tinyMCE.get('tinymceFooter').getContent();
			if($scope.selectedCartItemOnPopUp.colorAd == "colorAd"){
			$scope.footerColor = true;
			$scope.bodyColor = true;
		}
		}else if($scope.selectedCartItemOnPopUp.imageAd == 5){
			//Enable All TextEditor
			$scope.showImagePreview = true; 
			$scope.showImageUploadOption = true;//enable the image uploadear
			console.log("$scope.selectedCartItemOnPopUp.imageAd"+$scope.selectedCartItemOnPopUp.imageAd);
			$scope.imageId = $scope.selectedCartItemOnPopUp.imageAd;
			$scope.descriptionHeader = true;
			$scope.descriptionBody = true;
			$scope.descriptionFooter = true;
			console.log($scope.selectedCartItemOnPopUp.description);
			$scope.descriptionHeaderText = true;
			$scope.descriptionBodyText = true;
			$scope.descriptionFooterText = true;
			
			$scope.selectUrlForAdStore($scope.imageId);
			// display the a;; section of adPreview
			document.getElementById('descriptionHeaderText').innerHTML = tinyMCE.activeEditor.getContent();
    		document.getElementById('descriptionBodyText').innerHTML = tinyMCE.get('tinymceBody').getContent();
    		document.getElementById('descriptionFooterText').innerHTML = tinyMCE.get('tinymceFooter').getContent();
    		
    		if($scope.rc.composeWizard.currentIndex   == 2){
    		if ( tinyMCE.activeEditor.getContent() == "" ||
    				tinyMCE.get('tinymceBody').getContent() == "" ||
    				tinyMCE.get('tinymceFooter').getContent() == "" ){
    			  //  alert("Please fill all Ad details");
    			     //used to move to step(1) current step
    			    $scope.checkAllAdField();
    			  
    		}
    		}
    		
    		if($scope.selectedCartItemOnPopUp.colorAd == "colorAd"){
			$scope.footerColor = true;
			$scope.headerColor = true;
			$scope.bodyColor  = true;
			}
		}
		if($scope.selectedCartItemOnPopUp.imageAd == "" || angular.isUndefined($scope.selectedCartItemOnPopUp.imageAd)){
			alert("Please Select the Ad ");
		}
		if( !(angular.isUndefined($scope.selectedCartItemOnPopUp.imageAd)) && (!$scope.selectedCartItemOnPopUp.imageAd == "")){
			/*$scope.rc.composeWizard.forward();*/
			 if($scope.rc.composeWizard.currentIndex == 1) {
					InitDatepicker();
				}
		}
	}
	
	//Change the AdTextSize 3*5 size 
	$scope.onFirstColumnSelected = function(){
	document.getElementById('adPreview').style.width = 4 + 'cm';
	document.getElementById('adPreview').style.height = 188.97 + 'px';
	}
	//Change the ad text Size to 5*3
	$scope.onSecondColumnSelected = function(){
		document.getElementById('adPreview').style.width = 8 + 'cm';
		document.getElementById('adPreview').style.height = 188.97 + 'px';
		
	}
	//initilize the tinyMCE Body option.
	$scope.tinymceOptionsBody = {
			//selector: "textarea",
			//descriptionHeader,descriptionBody,descriptionFooter
			setup: function(ed) {
			    	ed.on('change', function(e) {
			    		console.log("changing this..");
			    		console.log('change event', e);
			        	document.getElementById('descriptionBodyText').innerHTML = tinyMCE.get('tinymceBody').getContent();
			    		var ed = tinyMCE.activeEditor;
			    	    ed.getBody().style.backgroundColor  = $scope.selectedCartItemOnPopUp.bodyColor; /* dark green text */
			    	    $scope.selectedCartItemOnPopUp.colorBody = $scope.bodyColor;
			    	    console.log($("#adPreview").get(0).scrollHeight);
			    	    $scope.selectedCartItemOnPopUp.height =  (($("#adPreview").get(0).scrollHeight)/37.795276);
			    		computeRateByUnit();
			    	    console.log( $scope.selectedCartItemOnPopUp.height); 
			    	    console.log("$scope.selectedCartItemOnPopUp.bodyColor"+$scope.selectedCartItemOnPopUp.bodyColor);
			    	});
			    },
			    forced_root_block : false,
			    force_br_newlines : false,
			    force_p_newlines : false,
			    menubar : false,
			    theme_advanced_font_sizes: "4px,6px,8px,10px,12px,14px,16px",
			    font_size_style_values: "6px,8px,10px,12px,14px,16px",
			plugins: [
			"advlist autolink lists link image charmap print preview anchor",
			"textcolor"
			],
			toolbar: "insertfile undo redo | bold italic | alignleft aligncenter alignright alignjustify |forecolor backcolor | fontsizeselect"
		}
	
	
	//initilize the tinyMCE Footer option.
	$scope.tinymceOptionsFooter = {
			//selector: "textarea",
			 setup: function(ed) {
			    	ed.on('change', function(e) {
			    		console.log('change event', e);
			    		document.getElementById('descriptionFooterText').innerHTML = tinyMCE.get('tinymceFooter').getContent();
			    		var ed = tinyMCE.activeEditor;
			    	    ed.getBody().style.backgroundColor  = $scope.selectedCartItemOnPopUp.footerColor;
			    	    console.log( $("#adPreview").get(0).scrollHeight);
			    	    $scope.selectedCartItemOnPopUp.height =  (($("#adPreview").get(0).scrollHeight)/37.795276);
			    	console.log( $scope.selectedCartItemOnPopUp.height);  	 
			    	computeRateByUnit();
			    	});
			    },
			    forced_root_block : false,
			    force_br_newlines : false,
			    force_p_newlines : false,
			    menubar : false,
			    theme_advanced_font_sizes: "4px,6px,8px,10px,12px,14px,16px",
			    font_size_style_values: "6px,8px,10px,12px,14px,16px",
			plugins: [
			"advlist autolink lists link image charmap print preview anchor",
			"textcolor"
			],
			toolbar: "insertfile undo redo | bold italic | alignleft aligncenter alignright alignjustify |forecolor backcolor | fontsizeselect"
		}
	
	
//	console.log("Header Text: "+$scope.selectedAdbodyTextOnPopUp.descriptionHeader);
	//initilize the tinyMCE Header option.
	$scope.tinymceOptions = {
			 setup: function(ed) {
			    	ed.on('change', function(e) {
			    		console.log("changing this..");
			    		document.getElementById('descriptionHeaderText').innerHTML = tinyMCE.activeEditor.getContent();
			    		console.log('change event', e);
			            // tinyMCE.activeEditor.dom.setStyle(tinyMCE.activeEditor.dom.select('p'), 'backgroundColor', $scope.headerColor);
			             var ed = tinyMCE.activeEditor;
				    	 ed.getBody().style.backgroundColor  = $scope.selectedCartItemOnPopUp.headerColor;
				    	 console.log($("#adPreview").get(0).scrollHeight);
				    	 $scope.selectedCartItemOnPopUp.height =  (($("#adPreview").get(0).scrollHeight)/37.795276);
			         	 console.log( $scope.selectedCartItemOnPopUp.height); 
				    	 computeRateByUnit();
				    	});
			 },
			    forced_root_block : false,
			    force_br_newlines : false,
			    force_p_newlines : false,
			    strong : false,
			    menubar : false,
			    theme_advanced_font_sizes: "4px,6px,8px,10px,12px,14px,16px",
			    font_size_style_values: "6px,8px,10px,12px,14px,16px",
			    
			plugins: [
			"advlist autolink lists link image charmap print preview anchor",
			"textcolor"
			],
			toolbar: "insertfile undo redo | bold italic | alignleft aligncenter alignright alignjustify |forecolor backcolor | fontsizeselect"
			}
}]);

angular.module('adschela').controller("dispclassifiedcontroller",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("AddisplayController",['$scope',function($scope){
	    $scope.init = function(dispadData) {
		$scope.resultCategory=dispadData.categories;
		$scope.resultNewspaperCategory =dispadData.newspapers;
	    console.log(dispadData.newspapers);
		}
}]);

angular.module('adschela').controller("AffiliatedloginController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("ENewsPaperController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("BlogController",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("HomeScreenController",['$scope',function($scope){
	
}]);



angular.module('adschela').controller('AddCategorySubcatController',function($scope, $modal, $http, $filter, CategoryService,deleteSubCategoryService){
	
		
	$scope.cname = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	var totalPages;
	$scope.isChosen = false;
	
	$http.get('getUserInfo')
	.success(function(data){
		if(data) {
			$scope.username = data.username;
			console.log("$scope.username"+$scope.username);
		} 
	});
	
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}
	
	$scope.deleteSubCategory = function() {
		deleteSubCategoryService.DeleteSubCategory.get({id :$scope.deleteId,deletedCID :$scope.deletedCID}, function(data){
			$scope.searchCategory(currentPage);
	        $('#myModal3').modal('hide');
		});    
	};
	
	$scope.Category = CategoryService.StateCityInfo.get({cname:$scope.cname,currentPage:currentPage},function(response) {
		totalPages = $scope.Category.totalPages;
		currentPage = $scope.Category.currentPage;
		$scope.pageNumber = $scope.Category.currentPage;
		$scope.pageSize = $scope.Category.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchCategory = function(page,category) {
			$scope.cname = category;
		if(angular.isUndefined($scope.cname) || $scope.cname=="") {
			console.log('inside function');
			$scope.cname = " ";
		}
		currentPage = page;
		
		$scope.Category = CategoryService.StateCityInfo.get({cname:$scope.cname,currentPage:currentPage},function(response) {
			console.log($scope.Category.totalPages);
			totalPages = $scope.Category.totalPages;
			currentPage = $scope.Category.currentPage;
			$scope.pageNumber = $scope.Category.currentPage;
			$scope.pageSize = $scope.Category.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	};
		
	$scope.saveCategory = function(category) {
	
      $http.post('/saveCategory',category).success(function(data){
			console.log('success');
			$scope.searchCategory(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};

	$scope.updateSubcategory = function(ancmt) {
		$scope.ancmtData = ancmt;
	//	$scope.ancmtData.Sucategory='';
		$('#myModal2').modal();
				
	};

	$scope.addNewCategory = function() {
		$scope.searchForm.from = new Date();
		$scope.searchForm.to = new Date();
		$scope.icon_id = "";
        $scope.icon_url = "";
        $scope.icon_name = "";
		$scope.formData = "";
		$scope.isChosen = false;
		$('#myModal').modal();
	}
		
	$scope.updateCategory = function() {
		
		$http.post('/updateSucategory', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchCategory(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};
	$scope.setDeleteId = function(Id) {
		$scope.deleteId = Id.CSID;
		$scope.deletedCID = Id.CID;
		$('#myModal3').modal();
	};
	$scope.onNext = function(cname) {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchCategory(currentPage,cname);
		}
	};
	$scope.onPrev = function(cname) {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchCategory(currentPage,cname);
		}
	};
	
 });
  angular.module('adschela').service('CategoryService',function($resource){
    this.StateCityInfo = $resource(
            '/getCategory/:cname/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
 });
 angular.module('adschela').service('deleteSubCategoryService',function($resource){
    this.DeleteSubCategory = $resource(
            '/deleteMainAndSubcategory/:id/:deletedCID',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
 });



angular.module('adschela').controller('AddStateCityController',function($scope, $modal, $http, $filter, StateCityService,deleteStateAndCitiesService){
	
	
	$scope.Statename = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	var totalPages;
	$scope.isChosen = false;
	
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}
	$http.get('getUserInfo')
	.success(function(data){
		if(data) {
			$scope.username = data.username;
			console.log("$scope.username"+$scope.username);
		} 
	});
	
	$scope.State = StateCityService.StateCityInfo.get({Statename:$scope.Statename,currentPage:currentPage},function(response) {
		totalPages = $scope.State.totalPages;
		currentPage = $scope.State.currentPage;
		$scope.pageNumber = $scope.State.currentPage;
		$scope.pageSize = $scope.State.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchState = function(page,Statename) {
			$scope.Statename = Statename;
		if(angular.isUndefined($scope.Statename) || $scope.Statename=="") {
			console.log('inside function');
			$scope.Statename = " ";
		}
		currentPage = page;
		
		$scope.State = StateCityService.StateCityInfo.get({Statename:$scope.Statename,currentPage:currentPage},function(response) {
			console.log($scope.State.totalPages);
			totalPages = $scope.State.totalPages;
			currentPage = $scope.State.currentPage;
			$scope.pageNumber = $scope.State.currentPage;
			$scope.pageSize = $scope.State.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	};
		
	$scope.saveState = function() {
	
      
      $http.post('/saveCity', $scope.formData).success(function(data){
			console.log('success');
			$scope.searchState(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};

	$scope.setData = function(ancmt) {
		
		$scope.ancmtData = ancmt;
	//	$scope.ancmtData.Cityname='';
		$('#myModal2').modal();
				
	};

	$scope.setDates = function() {
		$scope.searchForm.from = new Date();
		$scope.searchForm.to = new Date();
		$scope.icon_id = "";
        $scope.icon_url = "";
        $scope.icon_name = "";
		$scope.formData = "";
		$scope.isChosen = false;
		$('#myModal').modal();
	}

	$scope.setDeleteId = function(Id) {
		$scope.deleteId = Id.CID;
		console.log("-**-*-"+$scope.deleteId+"*-*-*-*");
		$('#myModal3').modal();
	};
	
	$scope.deleteStateAndCities = function() {
		deleteStateAndCitiesService.DeleteStateAndCities.get({id :$scope.deleteId}, function(data){
			$scope.searchState(currentPage);
	        $('#myModal3').modal('hide');
		});    
	};
	$scope.updateState = function() {
		$http.post('/updateState', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchState(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};

	$scope.onNext = function(Statename) {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchState(currentPage,Statename);
		}
	};
	$scope.onPrev = function(Statename) {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchState(currentPage,Statename);
		}
	};
	
	});
	angular.module('adschela').service('StateCityService',function($resource){
    this.StateCityInfo = $resource(
            '/getStateName/:Statename/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    	);
	});

	angular.module('adschela').service('deleteStateAndCitiesService',function($resource){
    this.DeleteStateAndCities = $resource(
            '/deleteStateAndCities/:id',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    	);
	});

angular.module('adschela').controller("MyAccountController",['$scope','$http','ngDialog',function($scope, $http,OrderListService,ngDialog){
	    
	     $scope.UserId=$scope.txtUsername;
	     console.log("$scope.txtUsername"+$scope.UserId);
	     console.log("MyAccountController");
	     
	 
	     $http.get("listInfo/"+$scope.UserId)
		 .success(function(data){
		  $scope.orderList = data;
		  console.log(" $scope.result"+ $scope.orderList);
		});

	     $scope.setInvoiceData = function(invoiceData) {
	    	$scope.grantTotal = 0;
	        
	 
	    $scope.orderId=invoiceData.orderId;
	    console.log(" $scope.orderId"+ $scope.orderId);
	  
	    //get the invoice Details
	    $http.get("getInvoiceOrderDetails/"+$scope.orderId)
		 .success(function(data){
			 if(data.results.length>0) {
				 $scope.orderData = data.results;
				 for(var i=0;i<data.results.length;i++){
					 $scope.grantTotal += (parseInt(data.results[i].TotalCost));
					 console.log("$scope.grantTotal"+$scope.grantTotal);
				 }
				 $scope.inVoiceHeader = data.results[0];
			 }
		  console.log(" $scope.result invoice"+JSON.stringify($scope.orderData));
		});
	   //get the adderess to  show on the invoice
	    $http.get("getaddressDetailsofUser")
		 .success(function(data){
				 $scope.addressDetails = data.addressDetails;
		         console.log(" $scope.result invoice"+JSON.stringify($scope.addressDetails));
		});
	    
	   // $scope.invoiceDetails( $scope.orderData,$scope.inVoiceHeader,$scope.addressDetails);
	 		
	 		$('#myModal2').modal();
	 				
	 	};
	    
	}]);

    angular.module('adschela').service('OrderListService',function($resource){
    this.orderListInfo = $resource(
            '/listInfo/:UserId',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});
angular.module('adschela').controller('AddNewspaperController',function($scope, $modal, $http, $filter, NewpaperService,deleteNewpaperService,getNewspaperservice,getCityNameservice,getStateNameservice,getcnameservice){
	$scope.Nameofthenewspaper = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	$scope.formData = {Unit: "Words"};
	var totalPages;
	$scope.isChosen = false;
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}

	$http.get('getUserInfo')
	.success(function(data){
		if(data) {
			$scope.username = data.username;
			console.log("$scope.username"+$scope.username);
		} 
	});
	
	$scope.Newspaper = NewpaperService.NewspaperInfo.get({Nameofthenewspaper:$scope.Nameofthenewspaper,currentPage:currentPage},function(response) {
		totalPages = $scope.Newspaper.totalPages;
		currentPage = $scope.Newspaper.currentPage;
		$scope.pageNumber = $scope.Newspaper.currentPage;
		$scope.pageSize = $scope.Newspaper.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchNewspaper = function(page,Nameofthenewspaper) {
			$scope.Nameofthenewspaper = Nameofthenewspaper;
		if(angular.isUndefined($scope.Nameofthenewspaper) || $scope.Nameofthenewspaper=="") {
			console.log('inside function');
			$scope.Nameofthenewspaper = " ";
		}
		currentPage = page;
		
		$scope.Newspaper = NewpaperService.NewspaperInfo.get({Nameofthenewspaper:$scope.Nameofthenewspaper,currentPage:currentPage},function(response) {
			console.log($scope.Newspaper.totalPages);
			totalPages = $scope.Newspaper.totalPages;
			currentPage = $scope.Newspaper.currentPage;
			$scope.pageNumber = $scope.Newspaper.currentPage;
			$scope.pageSize = $scope.Newspaper.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	};
		
	$scope.saveNewspaper = function(adNewNewsPaper) {
	  adNewNewsPaper.BasicratesperText="/"+adNewNewsPaper.Value+" "+adNewNewsPaper.Unit;
      $http.post('/saveNewpaper',adNewNewsPaper).success(function(data){
			console.log('success');
			$scope.searchNewspaper(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};
	
	$scope.setData = function(ancmt) {
		$scope.resultstate = getStateNameservice.Allstate.get();
		$scope.resultCity = [{cityname:ancmt.Nameofcities}];
		$scope.ancmtData = ancmt;
		$('#myModal2').modal();
				
	};
	$scope.onStateselect = function(statename) {
		console.log("State"+statename);
		$scope.resultCity = getCityNameservice.AllCity.get({state:statename}); 
		}
	$scope.onStateselectupdate = function() {
		console.log("State"+$scope.ancmtData.Statename)
		$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.ancmtData.Statename}); 
		}
	
	$scope.setDates = function() {
				
		$scope.resultstate = getStateNameservice.Allstate.get();
		
		$scope.searchForm.from = new Date();
		$scope.searchForm.to = new Date();
		$scope.icon_id = "";
        $scope.icon_url = "";
        $scope.icon_name = "";
		$scope.formData = "";
		$scope.isChosen = false;
		$('#myModal').modal();
	}
	$scope.setDeleteId = function(Id) {
		$scope.deleteId = Id.NewsId;
		console.log("-**-*-"+$scope.deleteId+"*-*-*-*");
		$('#myModal3').modal();
	};
	
	$scope.updateNewspaper = function() {
	/*	console.log($scope.ancmtData);
		$scope.formData.BasicratesperText="/"+$scope.formData.Value+" "+$scope.formData.Unit;*/
		$http.post('/updateNewpaper',$scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchNewspaper(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};
	
	$scope.deleteNewspaper = function() {
		deleteNewpaperService.Deletenewspaper.get({id :$scope.deleteId}, function(data){
			$scope.searchNewspaper(currentPage);
            $('#myModal3').modal('hide');
		});    
	};
	
	/*$scope.selectedFiles = [];
	$scope.dataUrls = [];
	$scope.tempSelectedFiles = [];
	$scope.onFileSelect = function($files) {
		console.log("Hello");
		if($scope.selectedFiles.length == 0) {
			$scope.tempSelectedFiles = [];
		}
	
		$scope.selectedFiles.push($files);
		$scope.tempSelectedFiles.push($files);
		for ( var i = 0; i < $files.length; i++) {
		
			var $file = $files[i];
			if (window.FileReader && $file.type.indexOf('image') > -1) {
			var fileReader = new FileReader();
			fileReader.readAsDataURL($files[i]);
				var loadFile = function(fileReader, index) {
					fileReader.onload = function(e) {
						$timeout(function() {
							$scope.dataUrls.push(e.target.result);
						});
					}
				}(fileReader, i);
			}
		}
		alert("selectedFile :: "+$scope.selectedFiles.length);
	};*/
	
	/*$upload.upload({
        url : '/image/uploadPhoto',
        method: $scope.httpMethod,
        data : {
            newsPaperId : id
        },
        file: $scope.commentTempSelectedFiles[i],
        fileFormDataName: 'photo'
    });*/
	
	$scope.onNext = function(Nameofthenewspaper) {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchNewspaper(currentPage,Nameofthenewspaper);
		}
	};
	$scope.onPrev = function(Nameofthenewspaper) {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchNewspaper(currentPage,Nameofthenewspaper);
		}
	};
	
});
angular.module('adschela').service('NewpaperService',function($resource){
    this.NewspaperInfo = $resource(
            '/getNewpaper/:Nameofthenewspaper/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});

angular.module('adschela').service('deleteNewpaperService',function($resource){
    this.Deletenewspaper = $resource(
            '/deleteNewpaper/:id',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    );
});



angular.module('adschela').controller('ViewAllRegisterUserController',function($scope, $modal, $http, $filter,ViewAllRegisteredUserService){

	$scope.userName = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	var totalPages;
	$scope.isChosen = false;
	
	$http.get('getUserInfo')
	.success(function(data){
		if(data) {
			$scope.username = data.username;
			console.log("$scope.username"+$scope.username);
		} 
	});
	
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}

	
	$scope.ViewAllRegisterUserController = ViewAllRegisteredUserService.ViewAllRegisteredUserInfo.get({userName:$scope.userName,currentPage:currentPage},function(response) {
		totalPages = $scope.ViewAllRegisterUserController.totalPages;
		currentPage = $scope.ViewAllRegisterUserController.currentPage;
		$scope.pageNumber = $scope.ViewAllRegisterUserController.currentPage;
		$scope.pageSize = $scope.ViewAllRegisterUserController.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
	
		$scope.searchViewAllRegisteredUser = function(page,userName) {
			
			$scope.userName = userName;
			console.log("$scope.userName"+$$scope.userName);
			
		if(angular.isUndefined($scope.userName) || $scope.userName=="") {
			console.log('inside function');
			$scope.userName = " ";
		}
		currentPage = page;
		
		$scope.ViewAllRegisterUserController = ViewAllRegisteredUserService.ViewAllRegisteredUserInfo.get({userName:$scope.userName,currentPage:currentPage},function(response) {
			console.log($scope.ViewAllRegisterUserController.totalPages);
			totalPages = $scope.ViewAllRegisterUserController.totalPages;
			currentPage = $scope.ViewAllRegisterUserController.currentPage;
			$scope.pageNumber = $scope.ViewAllRegisterUserController.currentPage;
			$scope.pageSize = $scope.ViewAllRegisterUserController.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	   
	};
	$scope.searchViewAllRegisteredUser = function(page,userName) {
		$scope.userName = userName;
		
		if(angular.isUndefined($scope.userName) || $scope.userName=="") {
			
			$scope.userName = " ";
		}
		currentPage = page;
		
		$scope.ViewAllRegisterUserController = ViewAllRegisteredUserService.ViewAllRegisteredUserInfo.get({userName:$scope.userName,currentPage:currentPage},function(response) {
			console.log($scope.ViewAllRegisterUserController.totalPages);
			totalPages = $scope.ViewAllRegisterUserController.totalPages;
			currentPage = $scope.ViewAllRegisterUserController.currentPage;
			$scope.pageNumber = $scope.ViewAllRegisterUserController.currentPage;
			$scope.pageSize = $scope.ViewAllRegisterUserController.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	    
	};
	angular.module('adschela').service('ViewAllRegisteredUserService',function($resource){
	    this.ViewAllRegisteredUserInfo = $resource(
	            '/viewAllRegisteredUserForAdmin/:userName/:currentPage',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get'}
	            }
	    );
	});
	
	
	
	$scope.onNext = function(userName) {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchViewAllRegisteredUser(currentPage,userName);
		}
	};
	$scope.onPrev = function(userName) {
		
		if(currentPage > 1) {
			currentPage--;
			$scope.searchViewAllRegisteredUser(currentPage,userName);
		}
	};
	
	});

	

	angular.module('adschela').service('ViewAllRegisteredUserService',function($resource){
        this.ViewAllRegisteredUserInfo = $resource(
            '/viewAllRegisteredUserForAdmin/:userName/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    	);
	});


angular.module('adschela').controller('ViewAllOrdersController',function($scope, $modal, $http, $filter,$sce,ViewAllOrdersService){

	$scope.orderId = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	var totalPages;
	$scope.isChosen = false;
	
	
	$http.get('getUserInfo')
	.success(function(data){
		if(data) {
			$scope.username = data.username;
			console.log("$scope.username"+$scope.username);
		} 
	});
	
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}
    //used to convert html unsafe code to plain text 
	$scope.to_trusted = function(html_code) {
	    return $sce.trustAsHtml(html_code);
	    console.log("in ntrusted");
	}
	
	
	$scope.viewAllOrder = ViewAllOrdersService.ViewAllOrderInfo.get({orderId:$scope.orderId ,currentPage:currentPage},function(response) {
		totalPages = $scope.viewAllOrder.totalPages;
		currentPage = $scope.viewAllOrder.currentPage;
		$scope.pageNumber = $scope.viewAllOrder.currentPage;
		$scope.pageSize = $scope.viewAllOrder.totalPages;
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
		$scope.searchViewAllOrderData = function(page,orderId) {
			$scope.orderId  = orderId;
		//	console.log("$scope.orderId "+$scope.orderId );
		if(angular.isUndefined($scope.orderId ) || $scope.orderId =="") {
			//console.log('inside function');
			$scope.orderId  = " ";
		}
		currentPage = page;
		$scope.viewAllOrder = ViewAllOrdersService.ViewAllOrderInfo.get({orderId:$scope.orderId ,currentPage:currentPage},function(response) {
			console.log($scope.viewAllOrder.totalPages);
			totalPages = $scope.viewAllOrder.totalPages;
			currentPage = $scope.viewAllOrder.currentPage;
			$scope.pageNumber = $scope.viewAllOrder.currentPage;
			$scope.pageSize = $scope.viewAllOrder.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	   
	};
	$scope.searchViewAllOrderData = function(page,orderId) {
		$scope.orderId  = orderId;
	//	console.log("$scope.orderId : "+$scope.orderId );
		if(angular.isUndefined($scope.orderId ) || $scope.orderId =="") {
			
			$scope.orderId = " ";
		}
		currentPage = page;
		
		$scope.viewAllOrder = ViewAllOrdersService.ViewAllOrderInfo.get({orderId:$scope.orderId ,currentPage:currentPage},function(response) {
			console.log($scope.viewAllOrder.totalPages);
			totalPages = $scope.viewAllOrder.totalPages;
			currentPage = $scope.viewAllOrder.currentPage;
			$scope.pageNumber = $scope.viewAllOrder.currentPage;
			$scope.pageSize = $scope.viewAllOrder.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	    
	};
	angular.module('adschela').service('ViewAllOrdersService',function($resource){
	    this.ViewAllOrderInfo = $resource(
	            '/viewAllOrdersForAdmin/:orderId/:currentPage',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get'}
	            }
	    );
	});
	
	  $scope.setInvoiceData = function(invoiceData) {
	    	$scope.grantTotal = 0;
	  
	 
	    $scope.orderId=invoiceData.OrderID;
//	    console.log(" $scope.orderId"+ $scope.orderId);
	  
	    //get the invoice Details
	    $http.get("getInvoiceOrderDetails/"+$scope.orderId)
		 .success(function(data){
			 if(data.results.length > 0) {
				 $scope.orderData = data.results;
				 for(var i=0;i<data.results.length;i++){
					 $scope.grantTotal += (parseInt(data.results[i].TotalCost));
				//	 console.log("$scope.grantTotal"+$scope.grantTotal);
				 }
				 $scope.inVoiceHeader = data.results[0];
				 console.log("data"+JSON.stringify(data.results[0]));
				 $scope.userUploadedAd = data.results[0].originalFileName;
				 console.log($scope.userUploadedAd);
				 if($scope.userUploadedAd == 'Image not Uploaded' ||  $scope.userUploadedAd == null || $scope.userUploadedAd == ''){
					// $('#myModelDispImage').modal();
					 $('#myModal2').modal();
				 }else{
				console.log("in mymodel");
					 $('#myModelDispImage').modal();
				 }
			 }
//		  console.log(" $scope.result invoice"+JSON.stringify($scope.orderData));
		});
	    
	   //get the addeess to  show on the invoice.
	    $scope.userEmailId = invoiceData.userEmailId;
	    console.log(" $scope.userEmailId: "+ $scope.userEmailId);
	    	$http.get("getaddressDetailsofUserForAdmin/"+$scope.userEmailId)
		 .success(function(data){
				 $scope.addressDetails = data.addressDetails;
		         console.log(" $scope.result invoice address"+JSON.stringify($scope.addressDetails));
		});
	    
	   // $scope.invoiceDetails( $scope.orderData,$scope.inVoiceHeader,$scope.addressDetails);
	    	/*if($scope.userUploadedAd == 'Image not Uploaded'){
				 $('#myModal2').modal();
			 }else{
				 $('#myModelDispImage').modal();
			 }*/
	 		
	 				
	 	};
	/*$scope.setData = function(ancmt) {
		$scope.ancmtData = ancmt;
		$('#myModal2').modal();
			
	};*/

	
	$scope.onNext = function(nameOfthenewspaper) {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchViewAllOrderData(currentPage,nameOfthenewspaper);
		}
	};
	$scope.onPrev = function(nameOfthenewspaper) {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchViewAllOrderData(currentPage,nameOfthenewspaper);
		}
	};
	
	});

	

	angular.module('adschela').service('ViewAllOrdersService',function($resource){
        this.ViewAllOrderInfo = $resource(
            '/viewAllOrdersForAdmin/:orderId/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    	);
	});

	

angular.module('adschela').controller('AddBasicRateController',function($scope, $modal, $http, $filter, BasicRateService,getNewspaperservice,getCityNameservice,getStateNameservice,getcnameservice, deleteBasicRateService){

	$scope.City = " ";
	$scope.category = " ";
	$scope.pageNumber;
	$scope.pageSize;
	$scope.formData = "";
	var currentPage = 1;
	var totalPages;
	$scope.isChosen = false;
	
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}

	$http.get('getUserInfo')
	.success(function(data){
		if(data) {
			$scope.username = data.username;
			console.log("$scope.username"+$scope.username);
		} 
	});
	
	
	$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,Category:$scope.category,currentPage:currentPage},function(response) {
		totalPages = $scope.BasicRate.totalPages;
		currentPage = $scope.BasicRate.currentPage;
		$scope.pageNumber = $scope.BasicRate.currentPage;
		$scope.pageSize = $scope.BasicRate.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
	
		$scope.searchBasicRate = function(page,nameOfNewspaper,category) {
			$scope.City = nameOfNewspaper;
			$scope.category = category;
			console.log("nameOfNewspaper"+nameOfNewspaper);

		if(angular.isUndefined($scope.City) || $scope.City=="") {
			console.log('inside function');
			$scope.City = " ";
		}

		if(angular.isUndefined($scope.category) || $scope.category == ""){
			$scope.category =" ";
		}
		currentPage = page;
		console.log($scope.City);
		console.log(currentPage);
		$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,Category:$scope.category,currentPage:currentPage},function(response) {
			console.log($scope.BasicRate.totalPages);
			totalPages = $scope.BasicRate.totalPages;
			currentPage = $scope.BasicRate.currentPage;
			$scope.pageNumber = $scope.BasicRate.currentPage;
			$scope.pageSize = $scope.BasicRate.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	    console.log($scope.BasicRate);
	};
	$scope.searchBasicRate = function(page,city,category) {
		$scope.City = city;
		$scope.category = category;
    	//console.log("$scope.City"+$scope.City);
		
		
		console.log("$scope.Category"+$scope.category);
		if(angular.isUndefined($scope.City) || $scope.City=="" ) {
			//console.log('inside function city' );
			$scope.City = " ";
		}
		
		if(angular.isUndefined($scope.category) || $scope.category=="") {
			//console.log('inside function category');
			$scope.category = " ";
		}

		
		currentPage = page;
		console.log($scope.City);
		console.log(currentPage);
		$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,Category:$scope.category,currentPage:currentPage},function(response) {
			console.log($scope.BasicRate.totalPages);
			totalPages = $scope.BasicRate.totalPages;
			currentPage = $scope.BasicRate.currentPage;
			$scope.pageNumber = $scope.BasicRate.currentPage;
			$scope.pageSize = $scope.BasicRate.totalPages;
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
	    //console.log($scope.BasicRate);
	};
	angular.module('adschela').service('BasicRateService',function($resource){
	    this.BasicRateInfo = $resource(
	            '/getBasicrate/:City/:Category/:currentPage',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get'}
	            }
	    );
	});
	console.log($scope.City);
	console.log($scope.BasicRate);
		
	
	$scope.saveBasicRate = function(formData) {
		console.log($scope.formData.Statename);
		$http.post('/saveBasicRate',formData).success(function(data){
			console.log('success');
			$scope.searchBasicRate(currentPage);
			$('#myModal').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR');
		});
	};
	
	$scope.setData = function(ancmt) {
		
		$scope.tickOption = '%';
		$scope.borderOption = '%';
		$scope.bgOption = '%';
		$scope.borderOption = 'rs';
		$scope.bgOption = 'rs';
		$scope.tickOption = 'rs';
			
		$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get(); 
		$scope.resultcname = getcnameservice.Allcname.get();
		$scope.resultstate = getStateNameservice.Allstate.get();
		$scope.resultCity = [{cityname:ancmt.City}];
		$scope.ancmtData = ancmt;
		$('#myModal2').modal();
			
	};

	$scope.onStateselect = function(stateName) {
		console.log("Selected State  : "+stateName);
		$scope.resultCity = getCityNameservice.AllCity.get({state:stateName}); 
		}
	$scope.onStateselectupdate = function() {
		alert("State"+$scope.ancmtData.Statename)
		$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.ancmtData.Statename}); 
		}
	
	
	$scope.createNewBasicRate = function() {

		$scope.borderOption = 'rs';
		$scope.bgOption = 'rs';
		$scope.tickOption = 'rs';
		
		$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get(); 
		$scope.resultcname = getcnameservice.Allcname.get();
		$scope.resultstate = getStateNameservice.Allstate.get();
		$scope.searchForm.from = new Date();
		$scope.searchForm.to = new Date();
		$scope.icon_id = "";
        $scope.icon_url = "";
        $scope.icon_name = "";
		$scope.formData = "";
		$scope.isChosen = false;
		$('#myModal').modal();
	}
	$scope.setDeleteId = function(Id,nameOfTheNewspaper,category) {
		$scope.nameOfTheNewspaper= nameOfTheNewspaper;
		$scope.category = category;
		$scope.deleteId = Id.BasicRateID;
		console.log("-**-*-"+$scope.deleteId+"*-*-*-*");
		$('#myModal3').modal();
	};
	
	$scope.updateBasicRate = function() {
		console.log($scope.ancmtData);
		$http.post('/updateBasicRate', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchBasicRate(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};
	
	$scope.deleteBasicRate = function() {
	
		deleteBasicRateService.Deletebasicrate.get({id :$scope.deleteId}, function(data){
			$scope.searchBasicRate(currentPage,$scope.nameOfTheNewspaper,$scope.category);
            $('#myModal3').modal('hide');
		});    
	};
	
	
	
	$scope.onNext = function(nameOfTheNewspaper,category) {
		
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchBasicRate(currentPage,nameOfTheNewspaper,category);
		}
	};
	$scope.onPrev = function(nameOfTheNewspaper,category) {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchBasicRate(currentPage,nameOfTheNewspaper,category);
		}
	};
	
	});

	angular.module('adschela').service('getNewspaperservice',function($resource){
        this.Allnewspaper = $resource(
            '/getNewspaper',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    	);
	});


	angular.module('adschela').service('getcnameservice',function($resource){
        this.Allcname = $resource(
            '/getCategory',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    	);
	});

	angular.module('adschela').service('getStateNameservice',function($resource){
        this.Allstate = $resource(
            '/getStatename',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    	);
	});

	angular.module('adschela').service('getCityNameservice',function($resource){
         this.AllCity = $resource(
            '/getCityname/:state',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get',isArray:true}
            }
    	);
	});


	angular.module('adschela').service('BasicRateService',function($resource){
        this.BasicRateInfo = $resource(
            '/getBasicrate/:City/:Category/:currentPage',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
    	);
	});

	angular.module('adschela').service('deleteBasicRateService',function($resource){
        this.Deletebasicrate = $resource(
            '/deleteBasicRate/:id',
            {alt:'json',callback:'JSON_CALLBACK'},
            {
                get: {method:'get'}
            }
             );
	});

	angular.module('adschela').controller('AddPackageRateController',function($scope, $modal, $http, $filter, PackageRateService,getNewspaperservice,getAllCitiesService,getcnameservice, deletePackageRateService){

		$scope.newsPaper = " ";
		$scope.category = " ";
		$scope.pageNumber;
		$scope.pageSize;
		$scope.formData = "";
		var currentPage = 1;
		var totalPages;
		$scope.isChosen = false;
		
		$http.get('getUserInfo')
		.success(function(data){
			if(data) {
				$scope.username = data.username;
				console.log("$scope.username"+$scope.username);
			} 
		});
		
		$scope.searchForm= {
	            from : new Date(),
	            to : new Date()

		}

		//Pacakge Rate(Discountprice Model ) come in the PackageRateService.
		//$scope.newsPaper =spassing the news paper as parameter from ui.
		$scope.packageRate = PackageRateService.PackageRateInfo.get({newsPaperName:$scope.newsPaper,category:$scope.category,currentPage:currentPage},function(response) {
			totalPages = $scope.packageRate.totalPages;
			currentPage = $scope.packageRate.currentPage;
			$scope.pageNumber = $scope.packageRate.currentPage;
			$scope.pageSize = $scope.packageRate.totalPages;
			
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
		
		
		    //used to search the  Package data on newspaper.
			$scope.searchPackageRate = function(page,newsPaperName,category) {
				$scope.newsPaper = newsPaperName;
				$scope.category  = category;
			if(angular.isUndefined($scope.newsPaper) || $scope.newsPaper=="") {
		//		console.log('inside function');
				$scope.newsPaper= " ";
			}
			if(angular.isUndefined($scope.category) || $scope.category=="") {
	//			console.log('inside function');
				$scope.category= " ";
			}
			
			currentPage = page;
			//Pacakge Rate(Discountprice Model ) come in the PackageRateService.
			$scope.packageRate = PackageRateService.PackageRateInfo.get({newsPaperName:$scope.newsPaper, category:$scope.category,currentPage:currentPage},function(response) {
				console.log($scope.packageRate.totalPages);
				totalPages = $scope.packageRate.totalPages;
				currentPage = $scope.packageRate.currentPage;
				$scope.pageNumber = $scope.packageRate.currentPage;
				$scope.pageSize = $scope.packageRate.totalPages;
				if(totalPages == 0) {
					$scope.pageNumber = 0;
				}
			});
		    console.log($scope.packageRate);
		};
		
		
		//used to get Pacakge Rate  from DiscountPrice model   in the PackageRateService.
		angular.module('adschela').service('PackageRateService',function($resource){
		    this.PackageRateInfo = $resource(
		            '/getDiscountRate/:newsPaperName/:category/:currentPage',
		            {alt:'json',callback:'JSON_CALLBACK'},
		            {
		                get: {method:'get'}
		            }
		    );
		});
		
			
		//new package saved here
		$scope.saveNewPackage = function(formData) {
			console.log($scope.formData.Statename);
			$http.post('/saveNewPackageRate',formData).success(function(data){
				console.log('success posted data');
				$scope.searchPackageRate(currentPage);
				$('#myModal').modal('hide');
			}).error(function(data, status, headers, config) {
				console.log('ERROR');
			});
		};
		//
		$scope.resultstate=[];
		$scope.updatePackageRate = function(ancmt) {
			$scope.tickOption = '%';
			$scope.borderOption = '%';
			$scope.bgOption = '%';
			$scope.borderOption = 'rs';
			$scope.bgOption = 'rs';
			$scope.tickOption = 'rs';
			
			//get newspaper name
			$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get();
			//get category from the NewspaperDetails 
			$scope.resultcname = getcnameservice.Allcname.get();
			//get state from the NewspaperDetails 
			$scope.resultCities = getAllCitiesService.AllCities.get();
			
			$scope.ancmtData = ancmt;
			$('#myModal2').modal();
				
		};
				
		//setting data to the model
		$scope.createNewPackage = function() {
			$scope.borderOption = 'rs';
			$scope.bgOption = 'rs';
			$scope.tickOption = 'rs';
			
			$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get(); 
			$scope.resultcname = getcnameservice.Allcname.get();
			$scope.resultCities = getAllCitiesService.AllCities.get();
//			console.log("$scope.resultstate"+getAllCitiesService.AllCities.get());
			$scope.searchForm.from = new Date();
			$scope.searchForm.to = new Date();
			$scope.icon_id = "";
	        $scope.icon_url = "";
	        $scope.icon_name = "";
			$scope.formData = "";
			$scope.isChosen = false;
			$('#myModal').modal();
		}
		
		//seting data Id  to the delete model. 
		$scope.setPackageDeleteId = function(Id,newspaperName,category) {
			$scope.deleteId = Id.Did;
			$scope.newspaperName = newspaperName;
			$scope.category = category;
			$('#myModal3').modal();
		};
		
		//update the  package rate in DiscountPrice model.
		$scope.updatePackageRateofSelectedPackage = function() {
			console.log($scope.ancmtData);
			$http.post('/updateDiscountRate', $scope.ancmtData).success(function(data){
				console.log('success');
				$scope.searchPackageRate(currentPage);
				$('#myModal2').modal('hide');
			}).error(function(data, status, headers, config) {
				console.log('ERROR------------');
			});
		};
		//delete the package rate from the  package rate(Discount price model ) 
		$scope.deleteDiscountRate = function() {
			deletePackageRateService.Deletebasicrate.get({id :$scope.deleteId}, function(data){
				console.log("$scope.category"+$scope.category);
				$scope.searchPackageRate(currentPage,$scope.newspaperName,$scope.category);
	            $('#myModal3').modal('hide');
			});    
		};
		
		
		// goto next page
		$scope.onNext = function(newspaperName,category) {
			if(currentPage < totalPages) {
				currentPage++;
				$scope.searchPackageRate(currentPage,newspaperName,category);
			}
		};
		//goto prevoius result (8 no of result per page )
		$scope.onPrev = function(newspaperName,category) {
			if(currentPage > 1) {
				currentPage--;
				$scope.searchPackageRate(currentPage,newspaperName,category);
			}
		};
		
		});
    
	//get newspaper name here 
		angular.module('adschela').service('getNewspaperservice',function($resource){
	        this.Allnewspaper = $resource(
	            '/getNewspaper',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get',isArray:true}
	            }
	    	);
		});

      //get category here
		angular.module('adschela').service('getcnameservice',function($resource){
	        this.Allcname = $resource(
	            '/getCategory',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get',isArray:true}
	            }
	    	);
		});
     //get state 
		angular.module('adschela').service('getAllCitiesService',function($resource){
	        this.AllCities = $resource(
	            '/getAllCityOfState',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get'}
	            }
	    	);
		});

	

		//get the package rate from the discount price model
		angular.module('adschela').service('PackageRateService',function($resource){
	        this.PackageRateInfo = $resource(
	            '/getDiscountRate/:newsPaperName/:category/:currentPage',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get'}
	            }
	    	);
		});
      //delete the package rate.
		angular.module('adschela').service('deletePackageRateService',function($resource){
		console.log("");
	        this.Deletebasicrate = $resource(
	            '/deleteDiscountRate/:id',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get'}
	            }
	             );
		});


	angular.module('adschela').controller("ComposeAdController",['$scope',function($scope, $timeout) {
	
	$scope.selectedCartItemOnPopUp = GetSelectedCartItemOnPopUp();
	var borderSelected;
	var totalCost;
	
	var borderColor;
	var backgroundColor;
	var borderColorInPer;
	var backgroundColorInPer;
	var extracostFortick;
	var extracostFortickInPer;
	
	var rate;
	var checkColorSelected;
	var savenameofcolorSelected;
	var extracostFortick;
	
    var bgColorSelected = $scope.selectedCartItemOnPopUp.onbgColorchange
	borderColor = parseInt($scope.selectedCartItemOnPopUp.extraForBorder);
	backgroundColor = parseInt($scope.selectedCartItemOnPopUp.extraForBackgroud);
	extracostFortick =  parseInt($scope.selectedCartItemOnPopUp.extraFortick);
	
	borderColorInPer = parseInt($scope.selectedCartItemOnPopUp.extraForBorderInPer);
	backgroundColorInPer = parseInt($scope.selectedCartItemOnPopUp.extraForBackgroudInPer);
	extracostFortickInPer =  parseInt($scope.selectedCartItemOnPopUp.extraFortickInPer);

	if ($scope.selectedCartItemOnPopUp.onBorderSelected == null || $scope.selectedCartItemOnPopUp.onBorderSelected == '') {
		$scope.selectedCartItemOnPopUp.onBorderSelected='No';
	}
	
	$scope.descFocusOut = function(event) {
		console.log(event);
	}
	
	$scope.onBorderselected = function(){
		if($scope.selectedCartItemOnPopUp.onBorderSelected == 'Yes') {
			upRate(borderColor,borderColorInPer);
		} else {
			downRate(borderColor,borderColorInPer);
		}
		ReTotal();
	}
	$scope.selectedCartItemOnPopUp.notickforAd=$scope.selectedCartItemOnPopUp.notickforAd;
	$scope.onNoTickSelected = function(){
		
		if($scope.selectedCartItemOnPopUp.notickforAd){
			downRate(extracostFortick,extracostFortickInPer);
		}
		else{
			upRate(extracostFortick,extracostFortickInPer);
		}
		ReTotal();
	}
	
	$scope.onNoBgcolorSelected=function(){
		  if($scope.selectedCartItemOnPopUp.nobgColor) { 
			  downRate(backgroundColor, backgroundColorInPer); 
			 $scope.selectedCartItemOnPopUp.onbgColorchange='No';
		  }
		  else {
			  upRate(backgroundColor, backgroundColorInPer) 
			  $scope.selectedCartItemOnPopUp.onbgColorchange='lemonchiffons';
		  }
		  ReTotal(); 
	}
	
	function downRate(inValue, inPer) {
		if(inValue != 0) {
			 $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - inValue;
		 } else if (inPer != 0){
			 $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - $scope.selectedCartItemOnPopUp.totalUnitCost * ((inPer)/(100));
		 } 
	}
	
	function upRate(inValue, inPer) {
		if(inValue != 0) {
		
			  $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + inValue;
		} else if (inPer != 0){
			$scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + $scope.selectedCartItemOnPopUp.totalUnitCost * ((inPer)/(100));
		} 
	}
	
	$scope.a=false ;
	$scope.onComposeAdStepChange = function() {
		
		if($scope.selectedCartItemOnPopUp.description != ""){
					$scope.rc.composeWizard.forward();
					$scope.a=false ;			
			}
		else{
			$scope.a=true;
			}
		
		if($scope.rc.composeWizard.currentIndex === 1) {
			
		}
		
		if($scope.rc.composeWizard.currentIndex == 2) {
			InitDatepicker();
		}
		
	}
	
	$scope.onComposeAdDone = function() {
		SaveToCart($scope.selectedCartItemOnPopUp);
		if($scope.selectedCartItemOnPopUp.dates == "")
			{
			alert("Please select date");
			}
		else{
				//used to close the opened Dialog
				closeDialog();
			}
	}
	
	$('body').on('blur','#translationArea',function(e) {
		console.log("capture focus out area... ");
		computeRateByUnit();
	});
	
	$scope.selectedCartItemOnPopUp.isHindi=false;
	$scope.transliterateDone = function(data) {
		console.log("$scope.selectedCartItemOnPopUp.isHindi " + $scope.selectedCartItemOnPopUp.isHindi);
		console.log(data);
		if($scope.selectedCartItemOnPopUp.isHindi) {
			$scope.$apply(function() {
				var tokens = $scope.selectedCartItemOnPopUp.description.split(" ");
				$scope.selectedCartItemOnPopUp.description = "";
				for(var i=0; i<tokens.length-1;i++) {
					$scope.selectedCartItemOnPopUp.description = $scope.selectedCartItemOnPopUp.description + tokens[i] + " ";	
				}
				$scope.selectedCartItemOnPopUp.description = $scope.selectedCartItemOnPopUp.description + data + " ";
			});
		}
		computeRateByUnit();
	};
	
	$scope.isEmptyOrBlank = function(str) {
		if (angular.isUndefined(str) || str == null || str == '') {
			return false;
		}  
		return true;

	};
	   
	function countWords(){
		s = $scope.selectedCartItemOnPopUp.description;
		s = s.replace(/(^\s*)|(\s*$)/gi,"");
		s = s.replace(/[ ]{2,}/gi," ");
		s = s.replace(/\n /,"\n");
		s = s.replace('@',"@ ");
		s = s.replace('-',"- ");
		s = s.replace('.',". ");
		s = s.replace(',',", ");
		s = s.replace('/',"/ ");
		s = s.replace('\\'," \\ ");
		return s.split(' ').length;
	}
	
	function computeRateByUnit() {
		console.log("calculating count.");
		dTotalPrice = parseInt($scope.selectedCartItemOnPopUp.dTotalPrice);
		
		rate = parseInt($scope.selectedCartItemOnPopUp.rate); //base rate for ad.
        var freeUnit = parseInt($scope.selectedCartItemOnPopUp.freeUnit); //total allowed free units.
        var unitLot = parseInt($scope.selectedCartItemOnPopUp.unitVal); //???
        var text = $scope.selectedCartItemOnPopUp.description;
        var freewords = parseInt($scope.selectedCartItemOnPopUp.freewords);
        console.log("freewords:"+freewords)
            if (text != '') {
                var total_unit;
                var extraUnit;
                if ($scope.selectedCartItemOnPopUp.unit == "Words") {
                	console.log("counting words");
                	total_unit = countWords(text);
                } else {
                	if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                    	total_unit = Math.ceil(text.length / freewords);
                    }
                }
                
                if (total_unit > freeUnit) {
                   //var extraUnitCost = $scope.selectedCartItemOnPopUp.extra;
                   var costt = parseInt($scope.selectedCartItemOnPopUp.extra);
                   extraUnit = total_unit - freeUnit;
                   if(unitLot > 0){
                     totalCost = rate + (costt * (extraUnit/unitLot));
                   }
                   else{
                   console.log("unitLot " + unitLot)
                   totalCost = rate + (costt * extraUnit);
                   }
                }
                else {
                	totalCost = rate;
                	console.log("in totle cost"+totalCost);
                }
              /*  if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                	total_unit = Math.ceil(text.length / 23);
                }*/
              $scope.$apply(function(){
                	$scope.selectedCartItemOnPopUp.totalUnit = total_unit;
                	$scope.selectedCartItemOnPopUp.extraCost = totalCost - rate;
                	$scope.selectedCartItemOnPopUp.totalUnitCost = totalCost;
                	$scope.selectedCartItemOnPopUp.extraUnit = extraUnit;
                	ReTotal();
              });
            }
            console.log($scope.selectedCartItemOnPopUp);
	}
	$scope.formatDate = function(cd) {
		return moment(cd).format('DD/MM/YYYY');
	}
}]);

angular.module('adschela').controller("ApplicationController",['$scope','$http','$cookies','$cookieStore','ngDialog','$sce',
                                                           function($scope,$http,$cookies,$cookieStore,ngDialog,$sce){
	$scope.carts = [];
	$scope.rates = [];
	$scope.discRates = [];
	$scope.orderListuser = [];
	$scope.orderIdPer = $cookies.orderId;
	$scope.orderIdStatus = $cookies.orderId;
	$scope.name;
	$scope.cookie = $cookies.cookie;
	$scope.selectYourAd = "";
	$scope.uploadyourAd = "templateSelect";
   	$scope.uploadyourAdSelect = "";
   	$scope.notemplateSelected = false;
	$scope.templateSelect = true;
	//$scope.notemplateSelected;
	$scope.imageAd = 'undefined';
	$scope.setImageIdUndefined = function(){
		$scope.imageAd = 'undefined';
	}
	$scope.selectUrlForAdStore = function(imageId){
		$scope.imageAd = imageId;
	}
	$scope.onTemplateSelected =  function(){
		console.log("in temp"+$scope.selectedCartItemOnPopUp.flag);
		$scope.uploadyourAd = "templateSelect";
		$scope.uploadyourAdSelect = "";
		$scope.notemplateSelected = false;
		$scope.templateSelect =  true;
	}
	
	$scope.onNoTemplateSelected =  function(){
	//	$scope.selectedCartItemOnPopUp.flag = "isUserUpload";
		console.log("in temp"+$scope.selectedCartItemOnPopUp.flag);
		$scope.uploadyourAd = '';
		$scope.notemplateSelected = true;
		$scope.templateSelect = false;
		$scope.uploadyourAdSelect = "userType";
		console.log($scope.uploadyourAdSelect);
	}
	
	$scope.selectOtherWidth = function(){
		$scope.defaultWidth = true;
		$scope.otherWidth = true;
		$scope.showImageUploadOption = false;
		$scope.showImagePreview = false; 
		//$scope.selectedCartItemOnPopUp.otherWidth = "3";
		console.log("$scope.selectedCartItemOnPopUp.otherWidth"+$scope.selectedCartItemOnPopUp.otherWidth);
	
	}
	//$scope.uploadyourAd = "templateSelect";
   		
	$scope.footerCheck =  function(){
	$scope.imgageHeight = $cookies.PLAY_SESSION;
	}
	console.log($scope.cookie);
	$scope.checkAllAdField =  function(){
		 $scope.rc.composeWizard.moveTo(1);
	}
	
	$scope.onAdChange  =  function(selectYourAd){
		$scope.selectYourAd  =  selectYourAd;
		DeleteAllBasicRateCartItem();
		console.log($scope.selectYourAd);
		$scope.setImageIdUndefined();
		$($('.backcolo')[0]).find('.Internal input:checked').trigger('click');
		$($('.backcolo')[1]).find('.Internal input:checked').trigger('click');
	}
	$scope.setCookie = function(){
		 $('#userInfopopup').hide();
		console.log($scope.cookie);
		if($scope.cookie == '' || angular.isUndefined($scope.cookie)){
	    	$http.get('getUserInfo')
	    	.success(function(data){
	    		if(data) {
	    			if(data != ''){
	    				 $scope.cookie = $cookies.cookie;
	    			}
	    		} 
	    	});
	    }
	}
	console.log(" $scope.lastVal"+ $scope.orderIdPer);
	 if(!($scope.orderIdStatus == '') ){
	    	$http.get("checkforOrderStatus/"+$scope.orderIdStatus)
			.success(function(data){
				console.log("$scope.orderIdPer"+$scope.orderIdPer);
				    $scope.orderStatus = data;
				    if($scope.orderStatus == 'false'){
			    		    $http.get("getOrderDetailsByOrderId/"+$scope.orderIdPer)
			    			.success(function(data){
			    		     $scope.tab=true;
			    			 setCancelOrderIdData(data.orderListuser);
			    			 PersistanceOrderItemDetails(data.orderListuser);
			    				 for(var i=0;i<data.orderListuser.length;i++){
			    				 $scope.selectYourAd = data.orderListuser[i].adSelectedType;
			    			 }
			    			 console.log("data obtained ordr:"+JSON.stringify(data.orderListuser));
			    			});
			    		}
			});
	    	
	    }
	//push the item to cart if the orderId is present in  cookies
		PersistanceOrderItemDetails = function(orderListuser){
			$scope.orderListuser = orderListuser;
			for(var i =0; i<$scope.orderListuser.length;i++){
			 PushToCart(PersistanceOrderItem($scope.orderListuser[i]));
			 $scope.orderListuser.isSelected = true;
			 //  DeleteCartPersistedItem($scope.orderListuser[i]);
		}
		
	 }
		//set if the no ad is selected (Default)
		if(angular.isUndefined($scope.selectYourAd ) || $scope.selectYourAd =="") {
			//console.log('inside function');
			$scope.selectYourAd  = "textClasified";
		}
		
		
		 function  PersistanceOrderItem (orderListuser) {
				return cartItem = {
						id:orderListuser.id,	
						OrderId:orderListuser.OrderId,
						hashKey: orderListuser.$$hashKey,	
						location: orderListuser.location,
						newspaper: orderListuser.newspaper,
						rate:orderListuser.rate,
						classifiedrate:orderListuser.ClasifiedadRate,
						unit: orderListuser.unit,
						unitVal: orderListuser.unitVal,
						extra: orderListuser.extra,
						freeUnit: orderListuser.freeunit,
						extraForBackgroud:orderListuser.extraForBackgroud,
						extraForBorder:orderListuser.extraForBorder,
						extraFortick:orderListuser.extraFortick,
						completenessStatus:'please fill details',
						freewords:orderListuser.freewords,
						description:orderListuser.description,
						total: 0,
						fullTotal: orderListuser.fullTotal,
						totalExtraCost :orderListuser.totalExtraCost ,
						totalUnitCost:orderListuser.totalUnitCost,
						noOfImpression:orderListuser.noOfImpression,
						extraCost: 0,	
						dates : orderListuser.dates,
						mainCategoty:orderListuser.mainCategoty,
						subcategory : orderListuser.subcategory,
						numberOfWords:orderListuser.numberOfWords,
						isHindi:true,
						onbgColorchange:orderListuser.onbgColorchange, 
						onBorderSelected:orderListuser.onBorderSelected,
						nobgColor:orderListuser.bgColorSelect,
						notickforAd:orderListuser.notickforAd,
						extraForBackgroudInPer:orderListuser.extraForBackgroudInPer,
						extraForBorderInPer:orderListuser.extraForBorderInPer,
						extraFortickInPer:orderListuser.extraFortickInPer,
						headerColor:orderListuser.headerColor ,
						bodyColor: orderListuser.bodyColor,
						footerColor:orderListuser.footerColor,
						descriptionHeader:orderListuser.descriptionHeader,
						descriptionBody:orderListuser.descriptionBody,	
						descriptionFooter:orderListuser.descriptionFooter,
						colorAd: orderListuser.colorAd,
						BWAd: orderListuser.colorAd,
						imageAd:orderListuser.imageAd,
						adSizeSelect:orderListuser.adSizeSelect,
						otherWidth:orderListuser.otherWidth,
						height:orderListuser.height,
						originalFileName:orderListuser.originalFileName,
						startDate:moment().add(2,'days').format("DD/MM/YYYY")
				    }
				}
	setCancelOrderIdData = function(orderListuser){
		$scope.orderListuser = orderListuser;
		angular.forEach($scope.carts, function(obj, index){
	    	angular.forEach($scope.orderListuser, function(request, key){
	    		if(request.id == obj.id) {
	    		request.isSelected = true;
            }
			});
	       return;
	  });
	}
	
	setDiscRates =  function (discRates) {
		$scope.discRates = discRates;
		angular.forEach($scope.carts, function(obj, index){
	    	angular.forEach($scope.discRates, function(request, key){
	    		if(request.id == obj.id) {
		     	   request.isSelected = true;
              }
			});
	       return;
	  });
	}
	
	SetRates = function (rates) {
		$scope.rates = rates;
		angular.forEach($scope.carts, function(obj, index){
	    	angular.forEach($scope.rates, function(request, key){
	    		
	    		if(request.id == obj.id) {
	    		  request.isSelected = true;
	            }
			});
	       	return;
	  });
		
	}
	
	$scope.to_trusted = function(html_code) {
	    return $sce.trustAsHtml(html_code);
	    console.log("in ntrusted");s
	}
	
	$scope.forgotpass=function(email){
		$scope.Send=false;
		$http.get("getforgotpass/"+$scope.email)
		.success(function(){
			$scope.Send=true;
		});
	}

	$scope.setSession = function(d){
		console.log(d);
		$scope.name = d;
	} 
	
	$scope.rate = 0;
		
	PushToCart = function(c) {
		$scope.carts.push(c);
		//c.
	}
	$scope.Login = function(){
		$('#myModal').modal();
	}
	$scope.Register = function(){
		$('#mySignUp').modal();
	}
	$scope.setnewuser = function() {
	
		$('#myModal').hide();
		$('#mySignUp').modal();
	}
	DeleteCartItemByDiscountRate = function(discountRate){
		 ///   $scope.FinalTotal = (parseInt($scope.selectedCartItemOnPopUp.FinalTotal));
			 angular.forEach($scope.carts, function(obj, index){
				 if ((discountRate.$$id === obj.id) || (discountRate.id === obj.id)) {
			    	$scope.carts.splice(index, 1);
			    	if(isNaN($scope.FinalTotal)){
			    		$scope.FinalTotal = 0;
			    	}
			    	
			    	 $scope.FinalTotal =  (parseInt($scope.FinalTotal)  - obj.fullTotal);
			    	 angular.forEach($scope.discountRate, function(request, key){
			    		if(request.id == discountRate.id) {
			            	request.isSelected = false;
			            }
			    	});
			       	return;
			    };
			  });
		}
	
	DeleteCartItemByRate = function(rate){
		 angular.forEach($scope.carts, function(obj, index){
			 if ((rate.$$id === obj.id) || (rate.id === obj.id)) {
		    	$scope.carts.splice(index, 1);
		    	if(isNaN($scope.FinalTotal)){
		    		$scope.FinalTotal = 0;
		    	}
		    	
		    	$scope.FinalTotal =  (parseInt($scope.FinalTotal)  - (obj.fullTotal));
		    	if($scope.FinalTotal < 0){
		    		     $scope.FinalTotal = 0;
		    	}
		    	
		    	angular.forEach($scope.rates, function(request, key){
		    		if(request.id == rate.id) {
		            	request.isSelected = false;
		            }
		    	});
		    	
		    	angular.forEach($scope.discRates, function(request, key){
		    		if(request.id == rate.id) {
		            	request.isSelected = false;
		            }
		    	});
		    	 
		       	return;
		    };
		   
		  });
		 
	}
	
	DeleteAllBasicRateCartItem = function(discountRate){
		if($scope.carts.length != 0)
		$scope.carts=[];
	}
	
	
	DeleteCartPersistedItem = function(orderListuser){
		 ///   $scope.FinalTotal = (parseInt($scope.selectedCartItemOnPopUp.FinalTotal));
			 angular.forEach($scope.carts, function(obj, index){
				 if ((orderListuser.$$id === obj.id) || (orderListuser.id === obj.id)) {
			    	$scope.carts.splice(index, 1);
			    	if(isNaN($scope.FinalTotal)){
			    	 $scope.FinalTotal = 0;
			    	}
			    	$scope.FinalTotal =  (parseInt($scope.FinalTotal)  - obj.fullTotal);
			    	angular.forEach($scope.orderListuser, function(request, key){
			    		if(request.id == orderListuser.id) {
			            request.isSelected = false;
			            }
			    	});
			       	return;
			    };
			  });
		}
	
	function CloneToCartItem(fromCart, fromScreen) {
		$scope.FinalTotal = 0;
		fromCart.description=fromScreen.description;
		fromCart.fullTotal=fromScreen.fullTotal;
		fromCart.dates=angular.copy(fromScreen.dates);
		fromCart.isHindi=fromScreen.isHindi;
		fromCart.extraCost=fromScreen.extraCost;
		fromCart.totalUnit=fromScreen.totalUnit;
		fromCart.rate=fromScreen.rate;
		fromCart.onbgColorchange=fromScreen.onbgColorchange;
		fromCart.onBorderSelected=fromScreen.onBorderSelected;
		fromCart.nobgColor=fromScreen.nobgColor;
		fromCart.totalExtraCost = fromScreen.totalExtraCost;
		fromCart.totalUnitCost = fromScreen.totalUnitCost;
		fromCart.extraCost = fromScreen.extraCost;
		fromCart.noOfImpression = fromScreen.noOfImpression;
		fromCart.extraUnit = fromScreen.extraUnit;
		fromCart.completenessStatus=fromScreen.completenessStatus;
		fromCart.extraFortick =  fromScreen.extraFortick;
		fromCart.notickforAd =   fromScreen.notickforAd;
		fromCart.finalTotal = fromScreen.finalTotal;
		fromCart.footerColor = fromScreen.footerColor;
		fromCart.headerColor = fromScreen.headerColor;
		fromCart.bodyColor = fromScreen.bodyColor;
		fromCart.descriptionHeader = fromScreen.descriptionHeader;
		fromCart.descriptionBody = fromScreen.descriptionBody;
		fromCart.descriptionFooter = fromScreen.descriptionFooter;
		fromCart.colorAd = fromScreen.colorAd;
		fromCart.BWAd = fromScreen.BWAd;
		fromCart.imageAd = fromScreen.imageAd;
		fromCart.adSizeSelect  = fromScreen.adSizeSelect;
		fromCart.otherWidth  = fromScreen.otherWidth;
		fromCart.height  = fromScreen.height;
		fromCart.originalFileName  = fromScreen.originalFileName;
		if(fromCart.dates.length == 0){
			fromCart.completenessStatus=true;
		}else if (fromCart.description==''){
			fromCart.completenessStatus=true;
		}
		else {
		   fromCart.completenessStatus=false;
		   fromCart.completenessStatus=false;
		}
	}
	
	SaveToCart = function(item) {
		var FinalTotal = 0;
		angular.forEach($scope.carts, function(obj, index){
		    if ((item.id === obj.id) || (item.id === obj.id)) {
		    	CloneToCartItem($scope.carts[index],item);
		    };
		    FinalTotal = ((FinalTotal) + parseInt(obj.fullTotal));
		    
		  });
		$scope.FinalTotal=0;
		$scope.FinalTotal = FinalTotal;
	}
	
	$scope.removeFromCart = function (c) {
		DeleteCartItemByRate(c);
	}
	$scope.updateCartItem = function (c) {
		ComposeAd(c);
	}
	
	$scope.updateDisplayCartItem = function (c) {
		ComposeDispAd(c);
	}
	
	$scope.selectedCartItemOnPopUp = {};
	SetSelectedCartItemOnPopUp = function(c) {
		$scope.selectedCartItemOnPopUp = angular.copy(c);
		console.log("$scope.selectedCartItemOnPopUp  " + JSON.stringify($scope.selectedCartItemOnPopUp));
	}
	
	GetSelectedCartItemOnPopUp = function() {
		return $scope.selectedCartItemOnPopUp;
	}
	$scope.previewAds=function(c,scope){
		console.log(c);
        $scope.selectednewspaper=c.newspaper;
		$scope.selectedCart = c.description;
		$scope.selectBorder=c.onBorderSelected;
		$scope.selectedcolor=c.onbgColorchange;
		$scope.isTickSelected = c.notickforAd;
	$scope.headerDesc = c.descriptionHeader;
	$scope.bodyDesc = c.descriptionBody;
	$scope.footerDesc = c.descriptionFooter;
	
	$scope.headerColor = c.headerColor;
	console.log("c.headerColor"+c.headerColor);
	$scope.bodyColor = c.bodyColor;
	$scope.footerColor = c.footerColor;
	
		ngDialog.open({
			template: 'newtheme/previewAds.html',
			className: 'ngdialog-theme-default',
			
			scope: $scope
		
				
		});
	}
	$scope.previewInvoiceAd=function(c,scope){
		//console.log(c);
		$scope.cartsItem  = {};
		$scope.cartsItem = c;
		$scope.grantTotal = 0;
		console.log("$scope.cartsItem"+JSON.stringify($scope.cartsItem));
        //set the header data to invoice 		
		for(var i=0;i<$scope.cartsItem.length;i++){
			$scope.headerItem = $scope.cartsItem[0];
			// $scope.grantTotal += (parseInt(cartsItem[i].fullTotal));
		}
		//set the body part and the grantTotal of the Invoice Data
		for(var i=0;i<$scope.cartsItem.length;i++){
			 $scope.grantTotal += (parseInt( $scope.cartsItem[i].fullTotal));
		}''
		//Display the order Placed Date on InvoiceAD before proceding  to payment.  
		var order = new Date()
		$scope.orderdate = order;
		 //set the address details to current logged In user, who is placing order
		$http.get("getaddressDetailsofUser")
		 .success(function(data){
				 $scope.addressDetails = data.addressDetails;
		         console.log(" $scope.result invoice"+JSON.stringify($scope.addressDetails));
		});
       /* $scope.selectednewspaper=c.newspaper;
		$scope.selectedCart = c.description;
		$scope.selectBorder=c.onBorderSelected;
		$scope.selectedcolor=c.onbgColorchange;
		$scope.isTickSelected = c.notickforAd;
		$scope.fullTotal = c.fullTotal;
	//	$scope.newspaper = c.newspaper;
		$scope.startDate  = c.startDate;
		$scope.dates = c.dates;
		$scope.location = c.location;
		$scope.mainCategoty = c.mainCategoty;
		*/
		
		ngDialog.open({
			template: 'newtheme/previewInvoiceAds.html',
			className: 'ngdialog-theme-default',
			scope: $scope
				
		});
	}
	 
	ComposeAd = function(c, scope) {
		SetSelectedCartItemOnPopUp(c);
		ngDialog.open({
			//template: 'newtheme/composeDisplayAd.html',
		   //controller:'ComposeDisplayAdController',
			template: 'newtheme/composeAd.html',
			scope:$scope,
			controller:'ComposeAdController',
			 className: 'ngdialog-theme-default'
		});
	}
	
	ComposeDispAd = function(c,scope){
		SetSelectedCartItemOnPopUp(c);
		ngDialog.open({
			template: 'newtheme/composeDisplayAd.html',
		   controller:'ComposeDisplayAdController',
		   scope:$scope,
		   //template: 'newtheme/composeAd.html',
			//controller:'ComposeAdController',
			 className: 'ngdialog-theme-default'
		});
		
	}
	
	//close the ng-dialog
	closeDialog =function(){
		ngDialog.close();
	}
	
	$scope.formatDate = function(cd) {
		return moment(cd).format('DD/MM/YYYY');
	}
	ReTotal = function () {
		console.log("calculating the total.. ");
		console.log($scope.selectedCartItemOnPopUp.noOfImpression + " " + $scope.selectedCartItemOnPopUp.totalUnitCost + " " + $scope.selectedCartItemOnPopUp.totalExtraCost);
		$scope.selectedCartItemOnPopUp.fullTotal = $scope.selectedCartItemOnPopUp.noOfImpression * 
		($scope.selectedCartItemOnPopUp.totalUnitCost + $scope.selectedCartItemOnPopUp.totalExtraCost);
	}
	
	InitDatepicker = function() {
		var costAfterTopping = $scope.selectedCartItemOnPopUp.total;
		$("#_datepicker").datepicker({
			multidate : true,
            format : "dd/mm/yyyy", 
            todayHighlight : true,
            //daysOfWeekDisabled: '0',
            startDate : $scope.selectedCartItemOnPopUp.startDate
        }).on("changeDate", function(e){
        	// TODO: If we dont put apply function , first time total is not applied on screen
        	$scope.$apply(function(){
        	var NumberOfDate = 0;
        	$scope.selectedCartItemOnPopUp.dates = e.dates;
        	$scope.selectedCartItemOnPopUp.noOfImpression = $scope.selectedCartItemOnPopUp.dates.length;
        	ReTotal();
        	});
        });
	
		$scope.dates=[];
		for(var i=0;i<=($scope.selectedCartItemOnPopUp.dates.length)-1;i++){
		    $scope.dates[i] = new Date($scope.selectedCartItemOnPopUp.dates[i]);
		    $scope.dates[i].setHours(0);
		    $scope.dates[i].setMinutes(0);
		    $scope.dates[i].setSeconds(0);
			}
		   $('#_datepicker').datepicker('setDate',$scope.dates);
		   console.log("$scope.dates: "+$scope.dates);
	}
}]);

	angular.module('adschela').controller("TextClassifiedController",['$scope',function($scope){
	$scope.init = function(beData) {
		$scope.requestScope = beData;
		} 	
	}]);

	angular.module('adschela').controller("SidebarController",['$scope',function($scope){
	$scope.init = function(beData) {
		$scope.sideRequest = beData;
		console.log($scope.sideRequest);
		}
	}]);

	angular.module('adschela').controller("MakeBookingController",['$scope','$http','$cookies','$cookieStore','ngDialog','$routeParams','$timeout','$upload',
                                                               function($scope,$http,$cookies,$cookieStore,ngDialog,$routeParams,$timeout,$upload){
		$scope.showFieldsVar = false;
		$scope.userId;
		$scope.selectedsubCategoty="";
		$scope.selectedsubCat="";
		$scope.rates1 = [];
		$scope.tab;
		$scope.userwithoutaccount='No';
		$scope.modeOfPayment='cc';
		$scope.disablePackageCheckBox=false;
		$scope.disableBasicRateChkbox=false;
				
		$scope.chkCategorySelectedforAD = function(){
			console.log("ghghg");
		}
		
		//console.log($scope.selectYourAd);
		//$scope.onAdChange();
		/*$scope.onAdChange  =  function(selectYourAd){
			$scope.selectYourAd  =  selectYourAd;
			DeleteAllBasicRateCartItem();
			console.log($scope.selectYourAd);
			$($('.backcolo')[0]).find('.Internal input:checked').trigger('click');
			$($('.backcolo')[1]).find('.Internal input:checked').trigger('click');
		//	$scope.onNewspaperSelect();
		}
		*/
		//retriving the cookies value if any cookies values(orderId)  is present on local.
		$scope.orderIdPer = $cookies.orderId;
		$scope.orderIdStatus = $cookies.orderId;
		console.log(" $scope.lastVal"+ $scope.orderIdPer);

		$scope.address={
			pinCode:'',
			fullName:'',
			shippingAddress:'',
			city:'',
			state:'',
			mobile:''
		};
		$scope.checkForAdDetailsFilled=function(){
			$scope.carts;
			$scope.errorDesc=false;
			$scope.errorDate=false;
			 $scope.rc.sampleWizard.forward();
			angular.forEach($scope.carts, function(value, key) {
			if(value.description == '' ){
				$scope.errorDesc=true;	
			}
			else if(value.dates == '' ){
				 $scope.errorDate=true;
			}
	   });
		if ($scope.carts.length ==0){
		if($scope.errorDate && $scope.errorDesc) {
	     $scope.rc.sampleWizard.forward();
		}
	 }
   }
	
	$scope.showfieldsonlyusername=function(showfieldstouser)
	{
		$scope.showFieldsVar = false;
	}
	$scope.showHomeShipingDetails=function(showHomeshipping){
		$scope.showHomeshipping=true;
		$scope.cashByHome;
		$scope.showDebitCardshipping=false;
	}
	
	$scope.showDebitShipingDetails=function(showDebitCardshipping){
		$scope.showHomeshipping=false;
		$scope.showDebitCardshipping=true;
		$scope.cashbyDebit;
		console.log("$scope.userId"+$scope.userId);
		$scope.showAddressDetails  = function()
		{
			$http({method:"GET",url:"/getaddressDetailsofUser"}).success(function(data){
			
				$scope.addressDetails=data.addressDetails;
				if(!(data == '')){
				 
				 $scope.address.fullName = data.addressDetails.fullName;
				 $scope.address.shippingAddress = data.addressDetails.address;
				 $scope.address.state= data.addressDetails.state;
				 $scope.address.city= data.addressDetails.city;
				 $scope.address.pinCode= data.addressDetails.pinCode;
				 $scope.address.mobile= data.addressDetails.mobile;
				}
		});
		}
	}
	$scope.showaddressDetails = function()
	{
		
	}
	$scope.onChangeCetegory = function(){
		$scope.subcategory = "";
		$scope.rc.sampleWizard.first();
		$scope.selectedsubCat = " ";
	}
	
	$scope.showfields=function(showfieldstouser){
		$scope.showFieldsVar = true;
	}
	$scope.init = function(beData) {
		$scope.bookingRequest = beData;
	}
	$scope.bookingState = {
			selectedMainCategoty: '',
			selectedNewsPaper:''
	}
	$scope.onfirestNewspaperSelect = function(np) {
		console.log("//////"+$scope.bookingState.selectedNewsPaper+"/////");
	}
	$scope.onCatSelected = function(cat) {
		$scope.tab=false;
		$scope.bookingState.selectedNewsPaper="";
		$scope.bookingState.selectedState="";
		$scope.bookingState.selectedCity="";
		$scope.bookingState.selectedMainCategoty = cat;
		$scope.rc.sampleWizard.forward();
		$scope.resultSubCategory = " ";
		$scope.selectedsubCat = " ";
		$scope.subcategory = "";
		if($scope.bookingState.selectedMainCategoty == "Matrimonial"){
			$scope.checkMatrimonial = true;
				
		}else{
			$scope.checkMatrimonial = false;
		}
		$http.get('getSubCategoty/'+$scope.bookingState.selectedMainCategoty)
		.success(function(data){
			if(data) {
				$scope.resultSubCategory = data;
				$scope.selectedMainCategoty = $scope.bookingState.selectedMainCategoty;
				console.log("$scope.resultSubCategory length:"+$scope.resultSubCategory.length);
				console.log("sub cat"+$scope.selectedsubCat);
			} else {
				$scope.resultSubCategory = [];
			}
		});
        
		if($scope.bookingState.selectedNewsPaper == "" || angular.isUndefined($scope.bookingState.selectedNewsPaper)){
		
		/*	$http.get('getAllNewsPaper')
			.success(function(data){
				if(data) {
					$scope.resultAllNewspaper = data;
					console.log("In AllNewsPapers");
					console.log(JSON.stringify($scope.resultAllNewspaper));
					//console.log("$scope.resultSubCategory"+$scope.resultSubCategory);
					//console.log("$scope.resultSubCategory length:"+$scope.resultSubCategory.length);
					//console.log("sub cat"+$scope.selectedsubCat);
				} 
			});
			*/
			$scope.bookingState.selectedNewsPaper = "Times of India";
			$http.get("getRatesByNewspaper/"+$scope.bookingState.selectedNewsPaper+'/'+$scope.bookingState.selectedMainCategoty+'/'+$scope.selectYourAd)
		    	.success(function(data){
		    	$scope.tab=true;
			    setDiscRates(data.discRates);
			    SetRates(data.rates);
		});
       }
		$scope.onSubcategorySelect = function(selectedsubCat){
			$scope.subcategory = selectedsubCat;
			$scope.selectedsubCat = selectedsubCat;
			console.log("selectedsubCat: "+$scope.subcategory);
		}
		$scope.checkForSubCategorySelect = function(){
			if($scope.selectYourAd == "" || angular.isUndefined($scope.selectYourAd)){
				$scope.selectYourAd = "textClasified"
			}
			console.log("in check sub cate");
			console.log("selectedsubCat: "+$scope.selectedsubCat);
			console.log("$scope.subcategory"+$scope.subcategory);
			console.log("length: sub category"+$scope.resultSubCategory.length);
			//angular.isUndefined($scope.subcategory)
			//$scope.subcategory == "" ||
			
			if($scope.resultSubCategory.length != 0){
				if($scope.selectedsubCat == " " || angular.isUndefined($scope.subcategory)){
				alert("Please Select Sub-Category ");
				}else{
					$scope.rc.sampleWizard.forward();
				}
			}else if($scope.resultSubCategory.length == 0 ){
				$scope.rc.sampleWizard.forward();
			}
		}	
	
	}
	
	$scope.checkForUsernameAndPassword = function(){
		$scope.showIframe = false;
		$("#ccIframe").html("");
		if($scope.userwithoutaccount == 'No'){
			var emailVar = $("#username").hasClass("ng-valid");
			if(emailVar){
			 $http.get("checkAlreadyExitUser/"+$scope.userId)
			 .success(function(data){
			  $scope.data=data;
			  if($scope.data == "true"){
					 $scope.alreadyRegister=$scope.data;
				 } 
				 if ($scope.data == "false"){
					 $scope.rc.sampleWizard.moveTo(4);
				 }
			});
			}
		} else if($scope.userwithoutaccount == 'Yes'){
			$scope.alreadyRegister=false;
			var emailVar = $("#username").hasClass("ng-valid");
		    if(emailVar  && (!$scope.userpass == '')){
			  $http.get("checkusercreadientals/"+$scope.userId+'/'+$scope.userpass)
		      .success(function(data){
		      $scope.result = data;
		      if($scope.result != "true") {
		    	  $scope.rc.sampleWizard.moveTo(4);
		    	  $scope.setSession(data);
		      }
		    });
		}}
	}
		
	$scope.tabchange=function(){
		$scope.bookingState.selectedNewsPaper="";
		$scope.bookingState.selectedState="";
		$scope.bookingState.selectedCity="";
		$scope.tab=false;
	}
	
	$scope.onCitySelect =function(){
		$http.get("getBasicRateByLocationAndCategory/"+$scope.bookingState.selectedCity+'/'+$scope.bookingState.selectedMainCategoty+'/'+$scope.selectYourAd)
		.success(function(data){
			$scope.tab=true;
			SetRates(data.rates);
			setDiscRates(data.discRates);
		});
	}
	 $scope.previousOrderId = $cookies.orderId;
	 console.log("$scope.previousOrderId "+$scope.previousOrderId);
	 console.log("$scope.orderIdPer"+$scope.orderIdPer);

	 $scope.onNewspaperSelect = function() {
		$http.get("getRatesByNewspaper/"+$scope.bookingState.selectedNewsPaper+'/'+$scope.bookingState.selectedMainCategoty+'/'+$scope.selectYourAd)
				.success(function(data){
					$scope.tab=true;
					    setDiscRates(data.discRates);
					    SetRates(data.rates);
				});
	}
	
	/* $scope.onNewspaperSelectInit = function() {
		 $scope.bookingState.selectedNewsPaper = "Times of India";
			$http.get("getRatesByNewspaper/"+$scope.bookingState.selectedNewsPaper+'/'+$scope.bookingState.selectedMainCategoty)
					.success(function(data){
						$scope.tab=true;
						    setDiscRates(data.discRates);
						    SetRates(data.rates);
					});
		}
	 */
    function NewDiscountCartItem(discountRate) {
		return discountCartItem = {
				id:discountRate.id,	
				hashKey: discountRate.$$hashKey,	
				location: discountRate.location,
				newspaper: discountRate.newspaper,
				rate: discountRate.dTotalPrice,
				classifiedrate: discountRate.ClasifiedadRate,
				unit: discountRate.unit,
				unitVal: discountRate.unitVal,
				extra: discountRate.extraCostperLine,
				freeUnit: discountRate.freeUnit,
				extraForBackgroud:discountRate.backColor,
				extraForBorder:discountRate.border,
				extraFortick:discountRate.extraFortick,
				extraForBackgroudInPer:discountRate.extraForBackgroudInPer,
				extraForBorderInPer:discountRate.extraForBorderInPer,
				extraFortickInPer:discountRate.extraFortickInPer,
				completenessStatus:'please fill details',
				packageSelected:discountRate.packageSelected,
				freewords:discountRate.freewords,
				description: '',
				total: 0, 
				fullTotal: 0,
				totalExtraCost : 0,
				totalUnitCost: 0,
				extraCost: 0,
				noOfImpression: 1,
				dates: [],
				mainCategoty: $scope.bookingState.selectedMainCategoty,
				subcategory : $scope.selectedsubCat,
				isHindi:true,
				onbgColorchange:'',
				onBorderSelected:'No',
				nobgColor:true,
				notickforAd: true,
				startDate:moment().add(2, 'days').format("DD/MM/YYYY")
		    }
		}

	function NewCartItem(rate) {
		return cartItem = {
			id:rate.id,	
			hashKey: rate.$$hashKey,	
			location: rate.location,
			newspaper: rate.newspaper,
			rate: rate.rate,
			classifiedrate: rate.classifiedrate,
			unit: rate.unit,
			unitVal: rate.unitVal,
			extra: rate.extra,
			freeUnit: rate.freeUnit,
			extraForBackgroud:rate.extraForBackgroud,
			extraForBorder:rate.extraForBorder,
			extraFortick:rate.extraFortick,
			extraForBackgroudInPer:rate.extraForBackgroudInPer,
			extraForBorderInPer:rate.extraForBorderInPer,
			extraFortickInPer:rate.extraFortickInPer,
			packageSelected:rate.packageSelected,
			completenessStatus:'please fill details',
			freewords:rate.freewords,
			description: '',
			total: 0,
			fullTotal: 0,
			totalExtraCost : 0,
			totalUnitCost: 0,
			extraCost: 0,
			noOfImpression: 1,
			dates: [],
			mainCategoty: $scope.bookingState.selectedMainCategoty,
			subcategory : $scope.subcategory,
			isHindi:true,
			onbgColorchange:'',
			onBorderSelected:'No',
			nobgColor:true,
			notickforAd: true,
			headerColor:'' ,
			bodyColor: '',
			footerColor:'',
			descriptionHeader:'',
			descriptionBody:'',	
			descriptionFooter:'',
			colorAd: '',
			BWAd: '',
			imageAd:'',
			adSizeSelect:'',
			otherWidth:'',
			height:'',
			originalFileName:'',
			startDate:moment().add(2, 'days').format("DD/MM/YYYY")
	    }
	}
	
	$scope.onStateSelect = function(statename) {
	
		$http.get("getcity/"+statename)
		.success(function(data){
			$scope.cities = data;
		});
	}
	
	var flag = true;
	
	$scope.discountRateClicked = function( e, discountRate ){
		$($('.backcolo')[0]).find('.Internal input:checked').trigger('click');
		
		
		$scope.disableBasicRateChkbox = true;
		if(flag == true){
			flag = false;
			DeleteAllBasicRateCartItem(discountRate);
		}
		
		if($(e.target).is(":checked")) {
			PushToCart(NewDiscountCartItem(discountRate, $scope.bookingState.selectedNewsPaper));
		} else {   
			DeleteCartItemByDiscountRate(discountRate);
		}
	}
	
	$scope.rateClicked = function(e, rate) {
		$($('.backcolo')[1]).find('.Internal input:checked').trigger('click');
		
	//	$scope.disablePackageCheckBox=true;
		if(flag == false){
			flag = true;
			DeleteAllBasicRateCartItem();
		}
		
		if($(e.target).is(":checked")) {
			PushToCart(NewCartItem(rate, $scope.bookingState.selectedNewsPaper));
		} else {
			DeleteCartItemByRate(rate);
			$scope.disablePackageCheckBox=false;
		}
	}
	
	$scope.rateClicked1 = function(e, rate) {
		if($(e.target).is(":checked")) {
			PushToCart(NewCartItem(rate, $scope.bookingState.selectedCity));
		} else {
			DeleteCartItemByRate(rate);
		}
	}
	
	$scope.discountRateTargetByCityClicked = function(e, discountRate ){
		console.log("in discountRateTargetByCityClicked ");
		if($(e.target).is(":checked")) {
			PushToCart(NewDiscountCartItem(discountRate, $scope.bookingState.selectedNewsPaper));
		} else {   
			DeleteCartItemByDiscountRate(discountRate);
		}
	}
	
	$scope.selectedCartItemOnPopUp = {};
	$scope.composeAd = function(c) {
		ComposeAd(c,$scope);
	}
	 
	$scope.composeDispAd = function(c){
		ComposeDispAd(c,$scope);
	}
 	$scope.onCartSubmit = function() {
     	//SubmitCart();
     	$scope.checkAllField=false;
     	if((!$scope.address.fullName == '') && (!$scope.address.shippingAddress == '') && (!$scope.address.state == '') &&(!$scope.address.pinCode == '') &&(!$scope.address.city == '') &&(!$scope.address.mobile == '')){  
     	    
     	    $http({method:"POST",url:"/submit-cart",
			data:{
				carts: $scope.carts,
				address:$scope.address,
				email:$scope.userId,
				modeOfPayment:$scope.modeOfPayment,
				adSelectedType:$scope.selectYourAd
			}
		}).success(function(data){
			
			$scope.showIframe = true;
			$("#ccIframe").html(data);
			if($scope.modeOfPayment === 'cod') {
				
			} else {
				window.location = data;
			}
			
		});
	
           }else{
       		$scope.checkAllField=true;
       	}*/
     	//console.log("uoload"+$scope.uploadyourAd);
     	//console.log("upload ad select"+$scope.uploadyourAdSelect);
     	//$scope.uploadyourAdSelect = "userType";
     	
     	
         if($scope.uploadyourAdSelect == "userType"){
           if((!$scope.address.fullName == '') && (!$scope.address.shippingAddress == '') && (!$scope.address.state == '') &&(!$scope.address.pinCode == '') &&(!$scope.address.city == '') &&(!$scope.address.mobile == '')){  
     		$scope.upload = $upload.upload({
     			url : '/submit-cartUserDisplayAd',
     			method : 'POST',
     			data:{
    				carts: $scope.carts,
    				address:$scope.address,
    				email:$scope.userId,
    				modeOfPayment:$scope.modeOfPayment,
    				adSelectedType:$scope.selectYourAd
    			},
     			fileFormDataName : 'file',
     			file :file
     			}).progress(function(evt) {
     			console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
     			}).success(function(data) {
     			$scope.showIframe = true;
     			console.log("inn if template");
     			$("#ccIframe").html(data);
    			/*if($scope.modeOfPayment === 'cod') {
    			} else {
    				window.location = data;
    			}*/
     			});
           }else{
		$scope.checkAllField=true;
	}
    }else if ($scope.uploadyourAd == "templateSelect" && $scope.imageAd == 'undefined'){
    	console.log("in else ");
    	if((!$scope.address.fullName == '') && (!$scope.address.shippingAddress == '') && (!$scope.address.state == '') &&(!$scope.address.pinCode == '') &&(!$scope.address.city == '') &&(!$scope.address.mobile == '')){  
    		$scope.upload = $upload.upload({
     			url : '/submit-cart',
     			method : 'POST',
     			data:{
    				carts: $scope.carts,
    				address:$scope.address,
    				email:$scope.userId,
    				modeOfPayment:$scope.modeOfPayment,
    				adSelectedType:$scope.selectYourAd
    			}
     			}).progress(function(evt) {
     			console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
     			}).success(function(data) {
     			$scope.showIframe = true;
     			console.log("inn if template");
     			$("#ccIframe").html(data);
    			/*if($scope.modeOfPayment === 'cod') {
    			} else {
    				window.location = data;
    			}*/
     			});
           }else{
       		$scope.checkAllField=true;
       	}
    }else if ($scope.uploadyourAd == "templateSelect" &&  $scope.imageAd == '5' ){
    	if((!$scope.address.fullName == '') && (!$scope.address.shippingAddress == '') && (!$scope.address.state == '') &&(!$scope.address.pinCode == '') &&(!$scope.address.city == '') &&(!$scope.address.mobile == '')){  
     		$scope.upload = $upload.upload({
     			url : '/submit-cartColorDisplayAd',
     			method : 'POST',
     			data:{
    				carts: $scope.carts,
    				address:$scope.address,
    				email:$scope.userId,
    				modeOfPayment:$scope.modeOfPayment,
    				adSelectedType:$scope.selectYourAd
    			},
     			fileFormDataName : 'file',
     			file :file
     			}).progress(function(evt) {
     			console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
     			}).success(function(data) {
     			$scope.showIframe = true;
     			console.log("inn if template");
     			$("#ccIframe").html(data);
    			/*if($scope.modeOfPayment === 'cod') {
    			} else {
    				window.location = data;
    			}*/
     			});
           }else{
		$scope.checkAllField=true;
	}
    }else if($scope.uploadyourAd == "templateSelect" &&  $scope.imageAd == '1' || $scope.imageAd == '2' ||$scope.imageAd == '3' ||$scope.imageAd == '4'){
    	if((!$scope.address.fullName == '') && (!$scope.address.shippingAddress == '') && (!$scope.address.state == '') &&(!$scope.address.pinCode == '') &&(!$scope.address.city == '') &&(!$scope.address.mobile == '')){  
    		$scope.upload = $upload.upload({
     			url : '/submit-cartDisplayHTMLAd',
     			method : 'POST',
     			data:{
    				carts: $scope.carts,
    				address:$scope.address,
    				email:$scope.userId,
    				modeOfPayment:$scope.modeOfPayment,
    				adSelectedType:$scope.selectYourAd
    			}
     			}).progress(function(evt) {
     			console.log('percent: ' + parseInt(100.0 * evt.loaded / evt.total));
     			}).success(function(data) {
     			$scope.showIframe = true;
     			console.log("inn if template");
     			$("#ccIframe").html(data);
    			/*if($scope.modeOfPayment === 'cod') {
    			} else {
    				window.location = data;
    			}*/
     			});
           }else{
       		$scope.checkAllField=true;
       	}
    	
    }
  }
	
	if($routeParams.id == 2){
		$timeout(function() {
			$scope.rc.sampleWizard.moveTo(2);
		},500);
	}
}]);
	
	

app.filter('setDecimal', function ($filter) {
	    return function (input, places) {
	        if (isNaN(input)) return input;
	        // If we want 1 decimal place, we want to mult/div by 10
	        // If we want 2 decimal places, we want to mult/div by 100, etc
	        // So use the following to create that factor
	        var factor = "1" + Array(+(places > 0 && places + 1)).join("0");
	        return Math.round(input * factor) / factor;
	    };
	});
