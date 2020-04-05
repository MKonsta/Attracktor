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
    username : 'Fedor',
    title : 'hello world',
    imageUrl : "https://opt-1031816.ssl.1c-bitrix-cdn.ru/upload/resize_cache/iblock/bc4/750_400_1/kakoj_oshejnik_luchshe_vybrat_dlja_shhenka.jpg?1528190458116324",
    content : 'About hello world',
    autorEmail : 'vova@mail.ru',
    like : true
};

let comment = {
    id : 87,
    postId : '23',
    username : 'Fedor',
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

function hideSplash() {
    document.getElementById("page-splash").hidden = true;
    document.body.classList.remove("no-scroll");
}

function showSplash() {
    document.getElementById("page-splash").hidden = false;
    document.body.classList.add("no-scroll");
}

function createCommentElement(comment) {
    let com = document.createElement('div');
    com.innerHTML = `<a href="#" class="muted">${comment.username}</a>
                       <p>${comment.content}</p>`;
    var attr = document.createAttribute("class");
    attr.value = "py-2 pl-3";
    com.setAttributeNode(attr);
    return com;
}

function addComment(com) {
   document.getElementById("comments").append(com);
}

function createPostElement(post) {
    let newPost = document.createElement("div");
    newPost.innerHTML = `<!-- image block start -->
                        <div>
                            <img class="d-block w-100" src="${post.imageUrl}" alt="Post image">
                        </div>
                        <!-- image block end -->
                        <div class="px-4 py-3">

                            <!-- post reactions block start -->
                            <div class="d-flex justify-content-around">
                              <span class="h1 mx-2 text-danger">
                                <i class="fas fa-heart"></i>
                              </span>
                                <span class="h1 mx-2 muted">
                                    <i class="far fa-heart"></i>
                                </span>
                                <span class="h1 mx-2 muted">
                                    <i class="far fa-comment"></i>
                                </span>
                                <span class="mx-auto"></span>
                                <span class="h1 mx-2 muted">
                                    <i class="far fa-bookmark"></i>
                                </span>
                                <span class="h1 mx-2 muted">
                                    <i class="fas fa-bookmark"></i>
                                </span>
                            </div>
                            <!-- post reactions block end -->
                            <hr>
                            <!-- post section start -->
                            <div>
                                <p>${post.content}</p>
                            </div>
                            <!-- post section end -->
                            <hr>
                            <!-- comments section start -->
                            <div id="comments">
                                
                                <button onclick="addComment(createCommentElement(comment))">add comment</button>
                            </div>
                            <!-- comments section end -->`;

    var attr = document.createAttribute("class");
    attr.value = "card my-3";
    newPost.setAttributeNode(attr);
    console.log(newPost);
    return newPost;
}

function addPost(newPost) {
    document.getElementById("posts").append(newPost);
}




