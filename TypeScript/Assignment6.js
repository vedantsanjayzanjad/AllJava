var Item = /** @class */ (function () {
    function Item(itemid, itemname, itemprice, category) {
        this.itemid = itemid;
        this.itemname = itemname;
        this.itemprice = itemprice;
        this.category = category;
    }
    return Item;
}());
var getItemDetails = function (item) {
    console.log("itemid :" + item.itemid);
    console.log("itemname :" + item.itemname);
    console.log("itemprice :" + item.itemprice);
    console.log("category :" + item.category);
};
var itemObj = new Item(101, 'parle', 5, 'cookies');
getItemDetails(itemObj);
