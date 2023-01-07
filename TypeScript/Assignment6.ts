class Item {
    itemid: number;
    itemname: string;
    itemprice: number;
    category: string;
    
    constructor(itemid: number, itemname: string,itemprice: number,category: string) {
            this.itemid = itemid;
            this.itemname = itemname;
            this.itemprice = itemprice;
            this.category = category;
    }

}

let getItemDetails=(item:Item) => {
        console.log("itemid :"+item.itemid);
        console.log("itemname :"+item.itemname);
        console.log("itemprice :"+item.itemprice);
        console.log("category :"+item.category);
}

let itemObj = new Item(101,'parle',5,'cookies');
getItemDetails(itemObj);