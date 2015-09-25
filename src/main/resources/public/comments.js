//create module
var module = angular.module('Blog', ['ngResource']);

//create factory to be able to create Commen object + user resource url
module.factory('Comment', function($resource) {
    return $resource(':username/comments', { username: '@username' });
})
    //create controller which is used in index.html
    .controller('CommentsController', function($scope, $http, Comment) {
        var url = function() {
            return {username:$scope.username||'dkorolev'};
        }

        //update existing comments
        var update = function() {
            console.log(url());
            $scope.comments = Comment.query(url());
        };

        $scope.update = update;


        // add new comment function (save and clear textarea)
        $scope.add = function() {
            var comment = new Comment();
            comment.text = $scope.text;
            comment.date = new Date();
            comment.$save(url(), function() {
                $scope.text = "";
                update();
            })
        }


        // delete comment
        $scope.deleteComment = function (id) {
            Comment.delete(angular.extend(url(), {id: id}));
            update();
        }


        //search comments by criterias
        $scope.search = function() {
            var user = $scope.username||'dkorolev';
            console.log($scope.searchText);

            $http.get(user+'/comments/find', {params: {text : $scope.searchText}})
                .success(function(res) {
                    console.log(res);
                    $scope.comments = res;
                })
        }


        //use update by default (when page first loading)
        update();

});