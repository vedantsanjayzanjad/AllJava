interface ICalArea {
    radius?: number;
    height?: number;
    width?:number;
    getArea:(radius: number,height:number,width:number) => number;
}
class Cone implements ICalArea{
    height: number;
    radius: number;
    constructor(height: number, radius: number ) {
        this.height=height;
        this.radius=radius;
    }
    
    getArea: (radius: number, height: number, width: number): number {

    };
            

}
class Sphere {
    rad: number;
    constructor( rad: number ) {
        this.rad=rad;
    }
            

}class Rectangle {
    len: number;
    wid: number;
    constructor(len: number, wid: number ) {
        this.len=len;
        this.wid=wid;
    }
            

}
