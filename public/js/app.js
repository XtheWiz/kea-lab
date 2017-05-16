angular.module('kea-lab', [])
    .controller('ReportController', function($scope, $http) {
        var report = this;

        report.makeReport = function() {
            $http.get("http://localhost:8080/report", {
                params: {appId: report.appId}
            }).then(function(response){
                $scope.messages = response.data.messages;
                console.log(response);
            });
        }

});