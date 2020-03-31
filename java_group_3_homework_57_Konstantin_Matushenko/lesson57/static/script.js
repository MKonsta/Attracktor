'use strict';

let user = {
    id : 58,
    name : 'Volodya',
    email : 'vova@mail.ru',
    password : '123',
    isAutorised : false
};

//В объекте поста будет емаил автора, т.к. он уникальный
let post = {
    id : 23,
    title : 'hello world',
    content : 'About hello world',
    autorEmail : 'vova@mail.ru',
    like : true
};

let comment = {
    id : 87,
    postId : '23',
    authorEmail : 'vit@ru',
    content : 'good post'
};


let posts = [
        post,
        {
            id : 45,
            title : 'About Bish',
            content : 'this is a city',
            autorEmail : 'div@mail.ru',
        }
    ];


function addPostToArray(postsArray, post) {
    postsArray[postsArray.length] = post;
}

function autorisingUser(user) {
    if (!user.isAutorised) {
        user.isAutorised = true;
    }
}


function addDelLike(postId) {
    for (let i = 0; i < this.posts.length; i++) {
        if (posts[i].id === postId) {
            if (post[i].like) {
                post[i].like = false;
                return;
            } else {
                post[i].like = true;
            }
            break;
        }
    }
}