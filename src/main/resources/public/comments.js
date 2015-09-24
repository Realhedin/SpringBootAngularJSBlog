//create module
var module = angular.module('Blog', ['ngResource']);

//create factory to be able to create Commen object + user resource url
module.factory('Comment', function($resource) {
    return $resource(':username/comments', { username: '@username' });
})
    //create controller which is used in index.html
    .controller('CommentsController', function($scope, Comment) {
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


        //use update by default (when page first loading)
        update();

});