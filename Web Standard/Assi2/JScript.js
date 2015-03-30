//Random change Pic
function RandomPic() {
    document.getElementById('ShowImage').src = "Image/" + Math.round(Math.random() * 10) + ".gif";
}
//Change picture size according move over and move out
function MousePic(i,newSize) {
    i.width = newSize;
}
function MousePic2(i,oldSize) {
    i.width = oldSize;
}
//Change picture src 
function MouseC(i,target){
    document.getElementById(target).src = i.src;
}
//Time relate 
function getTime(target) {
    var obj = new Date();
    document.getElementById(target).innerHTML = obj.getHours() + ":" + obj.getMinutes() + ":" + obj.getSeconds();
}

