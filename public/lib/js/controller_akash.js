angular.module('adschela').controller("Booknewspaperaddonline",['$scope','beData',function($scope,beData){
	$scope.forTest = beData;
}]);

angular.module('adschela').controller("HeaderController",['$scope',function($scope){
}]);

angular.module('adschela').controller("FooterController",['$scope',function($scope){
}]);

angular.module('adschela').controller("IndexController",['$scope',function($scope){
	$scope.txtpasswords = 'password';
	$scope.nplist = [{name:"Amar Ujala",img:"/NewDesign/np-logos/amarujala.jpg"},
	                 {name:"Danik Jagaran",img:"/NewDesign/np-logos/dainikjagaran.png"},
	                 {name:"Hindustan",img:"/NewDesign/np-logos/hindustan.jpg"},
	                 {name:"Sandhya Times",img:"/NewDesign/np-logos/sandhyatimes.jpg"},
	                 {name:"Maharashtra Times",img:"/NewDesign/np-logos/maharashtratimes.jpg"},
	                 {name:"Vijay Karnataka",img:"/NewDesign/np-logos/vijaykarnataka.jpg"},
	                 {name:"Times of India",img:"/NewDesign/np-logos/toi.jpg"},
	                 {name:"Economic Times",img:"/NewDesign/np-logos/The-Economic-Times.png"},
	                 {name:"The Hindu",img:"/NewDesign/np-logos/Hindu.png"},
	                 {name:"Mirror",img:"/NewDesign/np-logos/MUMBAi MIRROR LOGO.jpg"},
	                 {name:"Deccan Herald",img:"/NewDesign/np-logos/Deccan-Herald.png"},
	                 {name:"Navbharat Times",img:"/NewDesign/np-logos/navbharat.gif"},
	                 {name:"Rajasthan Patrika",img:"/NewDesign/np-logos/rajasthanpatrika.jpg"},
	                 {name:"Prajavani",img:"/NewDesign/np-logos/prajavani.jpg"},
	                 {name:"udyavani-head",img:"/NewDesign/np-logos/udyavani-head.gif"},
	                 {name:"Kashmir Times",img:"/NewDesign/np-logos/Kashmir Times Logo.jpg"},
	                 {name:"Dainik Sambad",img:"/NewDesign/np-logos/dainik sambad.jpg"},
	                 {name:"Prothom alo",img:"/NewDesign/np-logos/prothom alo logo.jpg"},
	                 {name:"Inquilab",img:"/NewDesign/np-logos/Inquilab logo.jpg"},
	                 {name:"ABP",img:"/NewDesign/np-logos/ABP.png"},
	                 {name:"Deccan Chronicle",img:"/NewDesign/np-logos/deccanchronicle.jpg"},
	                 {name:"Assam Tribune",img:"/NewDesign/np-logos/assamtribune.jpg"},
	                 {name:"Daily Excelsior",img:"/NewDesign/np-logos/dailyexcelsior.jpg"},
	                 {name:"Daily Star",img:"/NewDesign/np-logos/dailystar.jpg"},
	                 {name:"Dainikbhaskar",img:"/NewDesign/np-logos/dainikbhaskar.jpg"},
	                 {name:"Dainikjugasankha",img:"/NewDesign/np-logos/dainikjugasankha.jpg"},
	                 {name:"Dharitri",img:"/NewDesign/np-logos/dharitri.jpg"},
	                 {name:"Dinakaran",img:"/NewDesign/np-logos/dinakaran.jpg"},
	                 {name:"Dinamalar",img:"/NewDesign/np-logos/dinamalar.jpg"},
	                 {name:"Dinamani",img:"/NewDesign/np-logos/dinamani.jpg"},
	                 {name:"Divyabhaskar",img:"/NewDesign/np-logos/divyabhaskar.jpg"},
	                 {name:"DNA.jpg",img:"/NewDesign/np-logos/dna.jpg"},
	                 {name:"Easternchronicle",img:"/NewDesign/np-logos/easternchronicle.jpg"},
	                 {name:"Eenadu",img:"/NewDesign/np-logos/eenadu.jpg"},
	                 {name:"Ekdin",img:"/NewDesign/np-logos/ekdin.jpg"},
	                 {name:"Goa Messenger",img:"/NewDesign/np-logos/goamessenger.jpg"},
	                 {name:"Himalibela",img:"/NewDesign/np-logos/himalibela.jpg"},
	                 {name:"Janpath Samachar",img:"/NewDesign/np-logos/janpathsamachar.jpg"},
	                 {name:"Jugantor",img:"/NewDesign/np-logos/jugantor.jpg"},
	                 {name:"kannadaprabha",img:"/NewDesign/np-logos/kannadaprabha.jpg"},
	                 {name:"lokprabha",img:"/NewDesign/np-logos/lokprabha.jpg"},
	                 {name:"Lokmat",img:"/NewDesign/np-logos/Lokmat.jpg"},
	                 {name:"Ajit",img:"/NewDesign/np-logos/ajit.png"},	                 	                 
	                 {name:"Dainik-Kashmir-Times",img:"/NewDesign/np-logos/dainik-kashmir-times.png"},
	                 {name:"Gujarat Samachar",img:"/NewDesign/np-logos/gs-log-big.png"},
	                 {name:"Sanmagra",img:"/NewDesign/np-logos/image.gif"},
	                 {name:"Divya Marathi",img:"/NewDesign/np-logos/image.jpg"},
	                 {name:"Malayalamanorama",img:"/NewDesign/np-logos/malayalamanorama.jpg"},
	                 {name:"Mathrubhumi",img:"/NewDesign/np-logos/mathrubhumi.jpg"},
	                 {name:"Midday",img:"/NewDesign/np-logos/midday.jpg"},
	                 {name:"Naiduniaepaper",img:"/NewDesign/np-logos/naiduniaepaper.jpg"},
	                 {name:"Prothom alo",img:"/NewDesign/np-logos/prothom alo logo.jpg"},
	                 {name:"Punjab Kesri",img:"/NewDesign/np-logos/punjabkesri.jpg"},
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
	                 {name:"The-Telegraph",img:"/NewDesign/np-logos/The-Telegraph.png"},
	                 {name:"The-Tribune",img:"/NewDesign/np-logos/The-Tribune.png"},
	                 {name:"Navbharat",img:"/NewDesign/np-logos/navbharat.gif"},
	                 {name:"Navbharattimes",img:"/NewDesign/np-logos/navbharattimes.jpg"},
	                 {name:"Newbline",img:"/NewDesign/np-logos/newbline.png"},	                 	                 
	                 {name:"Prabhatkhabar",img:"/NewDesign/np-logos/prabhatkhabar.jpg"}];
	
	$scope.carousel= {
			interval : 6000
	}
    $scope.slides = [{
	      	image: '/NewDesign/images/classified-ad.jpg'
	    	},
		    {
			      image: '/NewDesign/images/all-np-1.jpg'
			},
	    	{
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
			},
		    {
			      image: '/NewDesign/images/banner11.jpg'
			}
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

angular.module('adschela').controller("dispclassifiedcontroller",['$scope',function($scope){
	
}]);
angular.module('adschela').controller("AddisplayController",['$scope',function($scope){
	    $scope.init = function(dispadData) {
	//	$scope.sideRequest = dispadData.;
		$scope.resultCategory=dispadData.categories;
		$scope.resultNewspaperCategory =dispadData.newspapers;
	    console.log(dispadData.newspapers);
	 //   console.log(dispadData.categories);
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



angular.module('adschela').controller('AddCategorySubcatController',function($scope, $modal, $http, $filter, CategoryService){
	
		
	$scope.cname = " ";
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

	
	$scope.Category = CategoryService.StateCityInfo.get({cname:$scope.cname,currentPage:currentPage},function(response) {
		totalPages = $scope.Category.totalPages;
		currentPage = $scope.Category.currentPage;
		$scope.pageNumber = $scope.Category.currentPage;
		$scope.pageSize = $scope.Category.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchCategory = function(page) {
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

	$scope.setData = function(ancmt) {
		
		$scope.ancmtData = ancmt;
		$scope.ancmtData.Sucategory='';
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
		
	$scope.updateCategory = function() {
		
		$http.post('/updateSucategory', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchCategory(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};

	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchCategory(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchCategory(currentPage);
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



angular.module('adschela').controller('AddStateCityController',function($scope, $modal, $http, $filter, StateCityService){
	
	
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

	
	$scope.State = StateCityService.StateCityInfo.get({Statename:$scope.Statename,currentPage:currentPage},function(response) {
		totalPages = $scope.State.totalPages;
		currentPage = $scope.State.currentPage;
		$scope.pageNumber = $scope.State.currentPage;
		$scope.pageSize = $scope.State.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchState = function(page) {
			
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
		$scope.ancmtData.Cityname='';
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
		
	$scope.updateState = function() {
		
		$http.post('/updateState', $scope.ancmtData).success(function(data){
			console.log('success');
			$scope.searchState(currentPage);
			$('#myModal2').modal('hide');
		}).error(function(data, status, headers, config) {
			console.log('ERROR------------');
		});
	};

	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchState(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchState(currentPage);
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

angular.module('adschela').controller("MyAccountController",['$scope','$http',function($scope, $http,OrderListService){
	    
	     $scope.UserId=$scope.txtUsername;
	     console.log("$scope.txtUsername"+$scope.txtUsername);
	     console.log("MyAccountController");
	    
	     $http.get("listInfo/"+$scope.txtUsername)
		 .success(function(data){
		  $scope.orderList = data;
		  
		  console.log(" $scope.result"+ $scope.orderList);
		});
	     
	     
	     
	     $scope.setData = function(ancmt) {
	 		$scope.orderData = ancmt;
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
	var totalPages;
	$scope.isChosen = false;
	$scope.searchForm= {
            from : new Date(),
            to : new Date()

	}

	$scope.Newspaper = NewpaperService.NewspaperInfo.get({Nameofthenewspaper:$scope.Nameofthenewspaper,currentPage:currentPage},function(response) {
		totalPages = $scope.Newspaper.totalPages;
		currentPage = $scope.Newspaper.currentPage;
		$scope.pageNumber = $scope.Newspaper.currentPage;
		$scope.pageSize = $scope.Newspaper.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
		$scope.searchNewspaper = function(page) {
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
		console.log("$scope.resultCity"+$scope.resultCity);
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
	
	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchNewspaper(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchNewspaper(currentPage);
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

angular.module('adschela').controller('AddBasicRateController',function($scope, $modal, $http, $filter, BasicRateService,getNewspaperservice,getCityNameservice,getStateNameservice,getcnameservice, deleteBasicRateService){

	$scope.City = " ";
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

	
	$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
		totalPages = $scope.BasicRate.totalPages;
		currentPage = $scope.BasicRate.currentPage;
		$scope.pageNumber = $scope.BasicRate.currentPage;
		$scope.pageSize = $scope.BasicRate.totalPages;
		
		if(totalPages == 0) {
			$scope.pageNumber = 0;
		}
	});
	
	
	
		$scope.searchBasicRate = function(page) {
		if(angular.isUndefined($scope.City) || $scope.City=="") {
			console.log('inside function');
			$scope.City = " ";
		}
		currentPage = page;
		console.log($scope.City);
		console.log(currentPage);
		$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
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
	$scope.searchBasicRate = function(page) {
		if(angular.isUndefined($scope.City) || $scope.City=="") {
			console.log('inside function');
			$scope.City = " ";
		}
		currentPage = page;
		console.log($scope.City);
		console.log(currentPage);
		$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
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
	angular.module('adschela').service('BasicRateService',function($resource){
	    this.BasicRateInfo = $resource(
	            '/getBasicrate/:City/:currentPage',
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
	
	
	$scope.setDates = function() {
				
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
	$scope.setDeleteId = function(Id) {
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
			$scope.searchBasicRate(currentPage);
            $('#myModal3').modal('hide');
		});    
	};
	
	
	
	$scope.onNext = function() {
		if(currentPage < totalPages) {
			currentPage++;
			$scope.searchBasicRate(currentPage);
		}
	};
	$scope.onPrev = function() {
		if(currentPage > 1) {
			currentPage--;
			$scope.searchBasicRate(currentPage);
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
            '/getBasicrate/:City/:currentPage',
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

	angular.module('adschela').controller('AddPackageRateController',function($scope, $modal, $http, $filter, BasicRateService,getNewspaperservice,getStateNameservice,getcnameservice, deleteBasicRateService){

		$scope.City = " ";
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

		//Pacakge Rate(Discountprice Model ) come in the BasicRateService.
		//$scope.city=spassing the news paper as parameter from ui.
		$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
			totalPages = $scope.BasicRate.totalPages;
			currentPage = $scope.BasicRate.currentPage;
			$scope.pageNumber = $scope.BasicRate.currentPage;
			$scope.pageSize = $scope.BasicRate.totalPages;
			
			if(totalPages == 0) {
				$scope.pageNumber = 0;
			}
		});
		
		
		    //used to search the  Package data on newspaper.
			$scope.searchBasicRate = function(page) {
			if(angular.isUndefined($scope.City) || $scope.City=="") {
				console.log('inside function');
				$scope.City = " ";
			}
			currentPage = page;
			//Pacakge Rate(Discountprice Model ) come in the BasicRateService.
			$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
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
		 //used to search the  Discount data on newspaper.
		$scope.searchBasicRate = function(page) {
			if(angular.isUndefined($scope.City) || $scope.City=="") {
				console.log('inside function');
				$scope.City = " ";
			}
			currentPage = page;
			//Pacakge Rate(Discountprice Model ) come in the BasicRateService.
			$scope.BasicRate = BasicRateService.BasicRateInfo.get({City:$scope.City,currentPage:currentPage},function(response) {
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
		//used to get Pacakge Rate  from DiscountPrice model   in the BasicRateService.
		angular.module('adschela').service('BasicRateService',function($resource){
		    this.BasicRateInfo = $resource(
		            '/getDiscountRate/:City/:currentPage',
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
				$scope.searchBasicRate(currentPage);
				$('#myModal').modal('hide');
			}).error(function(data, status, headers, config) {
				console.log('ERROR');
			});
		};
		//
		$scope.setData = function(ancmt) {
			//get newspaper name
			$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get();
			//get category from the NewspaperDetails 
			$scope.resultcname = getcnameservice.Allcname.get();
			//get state from the NewspaperDetails 
			$scope.resultstate = getStateNameservice.Allstate.get();
			console.log("$scope.resultstate"+$scope.resultstate);
			$scope.resultCity = [{cityname:ancmt.City}];
			$scope.ancmtData = ancmt;
			$('#myModal2').modal();
				
		};

		$scope.onStateselect = function(stateName) {
			console.log("Selected State  : "+stateName);
			//$scope.resultCity = getCityNameservice.AllCity.get({state:stateName}); 
			}
		$scope.onStateselectupdate = function() {
			alert("State"+$scope.ancmtData.Statename)
			//$scope.resultCity = getCityNameservice.AllCity.get({state:$scope.ancmtData.Statename}); 
			}
		
		//setting data to the model
		$scope.setDates = function() {
					
			$scope.resultNewspaper = getNewspaperservice.Allnewspaper.get(); 
			$scope.resultcname = getcnameservice.Allcname.get();
			$scope.resultstate = getStateNameservice.Allstate.get();
			console.log("$scope.resultstate"+getStateNameservice.Allstate.get());
			$scope.searchForm.from = new Date();
			$scope.searchForm.to = new Date();
			$scope.icon_id = "";
	        $scope.icon_url = "";
	        $scope.icon_name = "";
			$scope.formData = "";
			$scope.isChosen = false;
			$('#myModal').modal();
		}
		
		//seting data to the delete model. 
		$scope.setDeleteId = function(Id) {
			$scope.deleteId = Id.Did;
			$('#myModal3').modal();
			console.log("-**-*-"+$scope.deleteId+"*-*-*-*");
			
		};
		
		//update the  package rate in DiscountPrice model.
		$scope.updateBasicRate = function() {
			console.log($scope.ancmtData);
			$http.post('/updateDiscountRate', $scope.ancmtData).success(function(data){
				console.log('success');
				$scope.searchBasicRate(currentPage);
				$('#myModal2').modal('hide');
			}).error(function(data, status, headers, config) {
				console.log('ERROR------------');
			});
		};
		//delete the package rate from the  package rate(Discount price model ) 
		$scope.deleteDiscountRate = function() {
			deleteBasicRateService.Deletebasicrate.get({id :$scope.deleteId}, function(data){
				$scope.searchBasicRate(currentPage);
	            $('#myModal3').modal('hide');
			});    
		};
		
		
		// goto next page
		$scope.onNext = function() {
			if(currentPage < totalPages) {
				currentPage++;
				$scope.searchBasicRate(currentPage);
			}
		};
		//goto prevoius result (8 no of result per page )
		$scope.onPrev = function() {
			if(currentPage > 1) {
				currentPage--;
				$scope.searchBasicRate(currentPage);
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
		angular.module('adschela').service('getStateNameservice',function($resource){
	        this.Allstate = $resource(
	            '/getAllCityOfState',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get',isArray:true}
	            }
	    	);
		});

		/*angular.module('adschela').service('getCityNameservice',function($resource){
	         this.AllCity = $resource(
	            '/getCityname/:state',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get',isArray:true}
	            }
	    	);
		});*/

		//get the package rate from the discount price model
		angular.module('adschela').service('BasicRateService',function($resource){
	        this.BasicRateInfo = $resource(
	            '/getDiscountRate/:City/:currentPage',
	            {alt:'json',callback:'JSON_CALLBACK'},
	            {
	                get: {method:'get'}
	            }
	    	);
		});
      //delete the package rate.
		angular.module('adschela').service('deleteBasicRateService',function($resource){
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
	var rate;
	var checkColorSelected;
	var savenameofcolorSelected;
	var extraFortick;
	
    var bgColorSelected = $scope.selectedCartItemOnPopUp.onbgColorchange
	borderColor = parseInt($scope.selectedCartItemOnPopUp.extraForBorder);
	backgroundColor = parseInt($scope.selectedCartItemOnPopUp.extraForBackgroud);
	extracostFortick =  parseInt($scope.selectedCartItemOnPopUp.extraFortick);
	
	if ($scope.selectedCartItemOnPopUp.onBorderSelected == null || $scope.selectedCartItemOnPopUp.onBorderSelected == '') {
		$scope.selectedCartItemOnPopUp.onBorderSelected='No';
	}
	
	$scope.descFocusOut = function(event) {
		console.log(event);
	}
	
	$scope.onBorderselected = function(){
		if($scope.selectedCartItemOnPopUp.onBorderSelected == 'Yes') {
			$scope.selectedCartItemOnPopUp.totalExtraCost = 
			$scope.selectedCartItemOnPopUp.totalExtraCost + borderColor;
		} else {
			
			$scope.selectedCartItemOnPopUp.totalExtraCost = 
				$scope.selectedCartItemOnPopUp.totalExtraCost - borderColor;
		}
		ReTotal();
	}
	$scope.selectedCartItemOnPopUp.notickforAd=$scope.selectedCartItemOnPopUp.notickforAd;
	$scope.onNoTickSelected = function(){
	
		
		if($scope.selectedCartItemOnPopUp.notickforAd){
			 $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - extracostFortick;
			 console.log(" $scope.selectedCartItemOnPopUp.totalExtraCost:"+ $scope.selectedCartItemOnPopUp.totalExtraCost);
			}
		else{
			 $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + extracostFortick;
			 console.log(" $scope.selectedCartItemOnPopUp.totalExtraCost:"+ $scope.selectedCartItemOnPopUp.totalExtraCost);
		}
		ReTotal();
	}
	$scope.onNoBgcolorSelected=function(){
		
		  if($scope.selectedCartItemOnPopUp.nobgColor) { 
			 $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost - backgroundColor;
			 $scope.selectedCartItemOnPopUp.onbgColorchange='No';
		  }
		  else {
			  $scope.selectedCartItemOnPopUp.totalExtraCost = $scope.selectedCartItemOnPopUp.totalExtraCost + backgroundColor;
			  $scope.selectedCartItemOnPopUp.onbgColorchange='lemonchiffons';
		  }
		  ReTotal(); 
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
		return s.split(' ').length;
	}
	
	function computeRateByUnit() {
		console.log("calculating count.");
		dTotalPrice = parseInt($scope.selectedCartItemOnPopUp.dTotalPrice);
		
		rate = parseInt($scope.selectedCartItemOnPopUp.rate); //base rate for ad.
        var freeUnit = parseInt($scope.selectedCartItemOnPopUp.freeUnit); //total allowed free units.
        var unitLot = parseInt($scope.selectedCartItemOnPopUp.unitVal); //???
        var text = $scope.selectedCartItemOnPopUp.description;
            if (text != '') {
                var total_unit;
                var extraUnit;
                if ($scope.selectedCartItemOnPopUp.unit == "Words") {
                	console.log("counting words");
                	total_unit = countWords(text);
                } else {
                	if ($scope.selectedCartItemOnPopUp.unit == "Line") {
                    	total_unit = Math.ceil(text.length / 18);
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

angular.module('adschela').controller("ApplicationController",['$scope','$http','$cookies','$cookieStore','ngDialog',
                                                           function($scope,$http,$cookies,$cookieStore,ngDialog){
	$scope.carts = [];
	$scope.rates = [];
	$scope.discRates = [];
	$scope.orderListuser = [];
	$scope.orderIdPer = $cookies.orderId;
	$scope.orderIdStatus = $cookies.orderId;
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
		 function  PersistanceOrderItem (orderListuser) {
				return cartItem = {
						id:orderListuser.id,	
						hashKey: orderListuser.$$hashKey,	
						location: orderListuser.location,
						newspaper: orderListuser.newspaper,
						rate:orderListuser.rate,
						unit: orderListuser.unit,
						unitVal: orderListuser.unitVal,
						extra: orderListuser.extra,
						freeUnit: orderListuser.freeunit,
						extraForBackgroud:orderListuser.extraForBackgroud,
						extraForBorder:orderListuser.extraForBorder,
						extraFortick:orderListuser.extraFortick,
						completenessStatus:'please fill details',
						description:orderListuser.description,
						total: 0,
						fullTotal: orderListuser.fullTotal,
						totalExtraCost :orderListuser.totalExtraCost ,
						totalUnitCost:orderListuser.totalUnitCost,
						noOfImpression:orderListuser.noOfImpression,
						dates : orderListuser.dates,
						mainCategoty:orderListuser.mainCategoty,
						isHindi:true,
						onbgColorchange:orderListuser.onbgColorchange, 
						onBorderSelected:orderListuser.onBorderSelected,
						nobgColor:orderListuser.bgColorSelect,
						notickforAd:orderListuser.notickforAd,
					     
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
	
	$scope.forgotpass=function(email){
		$scope.Send=false;
		$http.get("getforgotpass/"+$scope.email)
		.success(function(){
			$scope.Send=true;
		});
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
		fromCart.noOfImpression = fromScreen.noOfImpression;
		fromCart.extraUnit = fromScreen.extraUnit;
		fromCart.completenessStatus=fromScreen.completenessStatus;
		fromCart.extraFortick =  fromScreen.extraFortick;
		fromCart.notickforAd =   fromScreen.notickforAd;
		fromCart.finalTotal = fromScreen.finalTotal;
		
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
	
		ngDialog.open({
			template: 'newtheme/previewAds.html',
			className: 'ngdialog-theme-default',
			scope: $scope
				
		});
	}
	
	ComposeAd = function(c, scope) {
		SetSelectedCartItemOnPopUp(c);
		ngDialog.open({
			template: 'newtheme/composeAd.html',
			controller:'ComposeAdController',
			className: 'ngdialog-theme-default'
		});
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

	angular.module('adschela').controller("MakeBookingController",['$scope','$http','$cookies','$cookieStore','ngDialog','$routeParams','$timeout',
                                                               function($scope,$http,$cookies,$cookieStore,ngDialog,$routeParams,$timeout){
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
			angular.forEach($scope.carts, function(value, key) {
			if(value.description == '' ){
				$scope.errorDesc=true;	
			}
			else if(value.dates == '' ){
				 $scope.errorDate=true;
			}
	   });
		if (! $scope.carts.length ==0){
		if(!$scope.errorDate && !$scope.errorDesc) {
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
		
		if($scope.bookingState.selectedMainCategoty == "Matrimonial"){
			$scope.checkMatrimonial = true;
				
		}else{
			$scope.checkMatrimonial = false;
		}
		$http.get('getSubCategoty/'+$scope.bookingState.selectedMainCategoty)
		.success(function(data){
			if(data) {
				$scope.resultSubCategory = data;
			} else {
				$scope.resultSubCategory = [];
			}
		});
	}
	
	$scope.checkForUsernameAndPassword =function(){
		if($scope.userwithoutaccount == 'No'){
			var emailVar = $("#username").hasClass("valid");
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
			console.log("next step with login..");
			$scope.alreadyRegister=false;
			var emailVar = $("#username").hasClass("valid");
		    if(emailVar && (!$scope.userpass == '')){
			  $http.get("checkusercreadientals/"+$scope.userId+'/'+$scope.userpass)
		      .success(function(data){
		      $scope.result = data;
		      if($scope.result == "false") {
		      $scope.rc.sampleWizard.moveTo(4);
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
		$http.get("getBasicRateByLocationAndCategory/"+$scope.bookingState.selectedCity+'/'+$scope.bookingState.selectedMainCategoty)
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
		$http.get("getRatesByNewspaper/"+$scope.bookingState.selectedNewsPaper+'/'+$scope.bookingState.selectedMainCategoty)
				.success(function(data){
					$scope.tab=true;
					    setDiscRates(data.discRates);
					    SetRates(data.rates);
				});
	}
	
    function NewDiscountCartItem(discountRate) {
		return discountCartItem = {
				id:discountRate.id,	
				hashKey: discountRate.$$hashKey,	
				location: discountRate.location,
				newspaper: discountRate.newspaper,
				rate: discountRate.dTotalPrice,
				unit: discountRate.unit,
				unitVal: discountRate.unitVal,
				extra: discountRate.extraCostperLine,
				freeUnit: discountRate.freeUnit,
				extraForBackgroud:discountRate.backColor,
				extraForBorder:discountRate.border,
				completenessStatus:'please fill details',
				description: '',
				total: 0,
				fullTotal: 0,
				totalExtraCost : 0,
				totalUnitCost: 0,
				noOfImpression: 1,
				dates: [],
				mainCategoty: $scope.bookingState.selectedMainCategoty,
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
			unit: rate.unit,
			unitVal: rate.unitVal,
			extra: rate.extra,
			freeUnit: rate.freeUnit,
			extraForBackgroud:rate.extraForBackgroud,
			extraForBorder:rate.extraForBorder,
			extraFortick:rate.extraFortick,
			completenessStatus:'please fill details',
			description: '',
			total: 0,
			fullTotal: 0,
			totalExtraCost : 0,
			totalUnitCost: 0,
			noOfImpression: 1,
			dates: [],
			mainCategoty: $scope.bookingState.selectedMainCategoty,
			isHindi:true,
			onbgColorchange:'',
			onBorderSelected:'No',
			nobgColor:true,
			notickforAd: true,
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
		console.log("discountRateClicked");
		
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
		console.log($scope.carts);
	}
	
	 
	$scope.rateClicked = function(e, rate) {
	//	$scope.disablePackageCheckBox=true;
		if(flag == false){
			flag = true;
			DeleteAllBasicRateCartItem();
		}
		
		
		if($(e.target).is(":checked")) {
			PushToCart(NewCartItem(rate, $scope.bookingState.selectedNewsPaper));
			//console.log("isSelected"+$scope.rate.isSelected);
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
	
	$scope.selectedCartItemOnPopUp = {};
	$scope.composeAd = function(c) {
		ComposeAd(c,$scope);
	}
	 
	$scope.onCartSubmit = function() {
     	console.log("In submit cart fun");
		//SubmitCart();
     	$scope.checkAllField=false;
     	if((!$scope.address.fullName == '') && (!$scope.address.shippingAddress == '') && (!$scope.address.state == '') &&(!$scope.address.pinCode == '') &&(!$scope.address.city == '') &&(!$scope.address.mobile == '')){  
     	    
     	    $http({method:"POST",url:"/submit-cart",
			data:{
				carts: $scope.carts,
				address:$scope.address,
				email:$scope.userId,
				modeOfPayment:$scope.modeOfPayment
			}
		}).success(function(data){
			console.log(data);
			if($scope.modeOfPayment === 'cod') {
				
			} else {
				window.location = data;
			}
			
		});
	
           }else{
		$scope.checkAllField=true;
	}
  }
	
	if($routeParams.id == 2){
		$timeout(function() {
			$scope.rc.sampleWizard.moveTo(2);
		},500);
	}
}]);
