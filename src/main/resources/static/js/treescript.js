var app = angular.module('treedata', []);
var hSize;
var treeSize;

function check_add() {
        if($('#add').val() !== '')
        $('#badd').removeAttr('disabled');
        else $('#badd').attr('disabled','disable'); 
};
function check_del() {
    if($('#del').val() !== '')
    $('#bdel').removeAttr('disabled');
    else $('#bdel').attr('disabled','disable'); 
};
function check_balance() {
        if(treeSize > 2)
        $('#balance').removeAttr('disabled');
        else $('#balance').attr('disabled','disable'); 
};
function check_clear() {
        if(treeSize > 0)
        $('#clear').removeAttr('disabled');
        else $('#clear').attr('disabled','disable'); 
};
function check_back() {
        if(hSize > 0)
        $('#back').removeAttr('disabled');
        else $('#back').attr('disabled','disable'); 
};
window.onload = function() {
};

app.controller("DataController", function ($scope, $http) {

    $scope.successGetTreeCallback = function (response) {
        $scope.str = response.data;
         console.log(response);
         console.log("DATA:");
         console.log(response.data.data);
         console.log("BFS:");
         console.log(response.data.bfs);
         console.log("CMD:");
         console.log(response.data.command);
         hSize = response.data.hsize;
         console.log("HSIZE:");
         console.log(hSize);
         treeSize = response.data.treeSize;
         console.log("TREESIZE:");
         console.log(treeSize);
         check_balance();
         check_back();
         check_clear();
        $scope.errormessage="";
    };

    $scope.errorGetTreeCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get list of tree";
    };

    $scope.getTree = function () {
        $http.get('/public/rest/data/').then($scope.successGetTreeCallback, $scope.errorGetTreeCallback);
    };

    $scope.successdeldataCallback = function (response) {
        //for (var i = 0; i < $scope.categoriesList.length; i++) {
        //    var j = $scope.categoriesList[i];
        //    if (j.id === $scope.deletedId) {
        //        $scope.categoriesList.splice(i, 1);
        //        break;
        //    }
        //}
        window.location.reload();
        $scope.errormessage="";
    };

    $scope.errordeldataCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to delete data";
    };

    $scope.delData = function () {
        //$scope.deletedId = id;
        $http.delete('/public/rest/data/' + $scope.deldata).then($scope.successdeldataCallback, $scope.errordeldataCallback);
    };


    /*$scope.successGetCategoriCallback = function (response) {
        $scope.categoriesList.splice(0 , 0, response.data);//$scope.categoriesList.length
        $scope.errormessage="";
    };

    $scope.errorGetCategoriCallback = function (error) {
        console.log(error);
        $scope.errormessage="Unable to get information on school number " + $scope.inputname;
    };*/

    $scope.successAddDataCallback = function (response) {
        //$scope.categoriesList.splice($scope.categoriesList.length, 0, response.data);//------$scope.categoriesList.length;
        //$http.get('/public/rest/res').then($scope.successGetCategoriCallback, $scope.errorGetCategoriCallback);
        //$scope.categoriesList.Push(response.data);
        window.location.reload();
        
        $scope.errormessage="";
    };

    $scope.errorAddDataCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to add new data";
    };

    $scope.addData = function () {
        $http.post('/public/rest/data/' + $scope.inputdata).then($scope.successAddDataCallback, $scope.errorAddDataCallback);
    };

    $scope.successClearCallback = function (response) {
        window.location.reload();
        $scope.errormessage="";
    };

    $scope.errorClearCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to clear data";
    };

    $scope.clearData = function () {
        $http.delete('/public/rest/data/').then($scope.successClearCallback, $scope.errorClearCallback);
    };

    $scope.successBalanceCallback = function (response) {
        window.location.reload();
        $scope.errormessage="";
    };

    $scope.errorBalanceCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to balance";
    };

    $scope.balanceData = function () {
        $http.post('/public/rest/data/').then($scope.successBalanceCallback, $scope.errorBalanceCallback);
    };
    
    $scope.successBackCallback = function (response) {
        window.location.reload();
        $scope.errormessage="";
    };

    $scope.errorBackCallback = function (error) {
        console.log(error);
        $scope.errormessage="Impossible to back data";
    };

    $scope.back = function () {
        $http.post('/public/rest/data/back').then($scope.successBackCallback, $scope.errorBackCallback);
    };

});