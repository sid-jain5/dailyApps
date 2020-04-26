export class NumberConvert {
    base1: string
    base2: string
    numberToConvert: string
    m = this.createHexaMap();
    baseConversion = new Map();

    constructor(base1: string, base2: string, numberToConvert: string) {
        this.baseConversion.set("binary","2")
        this.baseConversion.set("decimal","10")
        this.baseConversion.set("hexadecimal","16")
        this.baseConversion.set("octa","8")
        this.base1 = this.baseConversion.get(base1);
        this.base2 = this.baseConversion.get(base2);
        this.numberToConvert = numberToConvert;
    }

    convertNum(): string {

        if (this.base1 == '10') {
            console.log("decimal condition")
            return this.convertDecimalToAny(this.numberToConvert);
        }
        else if (this.base1 == '2' || this.base1 == '8') {
            let toDec: string;
            console.log("bonary and octa condition")
            toDec = this.convertAnyToDecimal();
            return this.convertDecimalToAny(toDec)
        }
        else if (this.base1 == '16') {
            let toDec: string;
            console.log("hexadecimal condition")
            toDec = this.convertHexaToDecimal();
            return this.convertDecimalToAny(toDec)
        }
        else {
            console.log("Some unknown base1 found")
            return '1';
        }

    }

    convertDecimalToAny(numn: string): string {
        let temp = new Number(numn) //this.numberToConvert;
        return temp.toString(+this.base2);
    }

    convertAnyToDecimal(): string {
        // console.log(+this.base2)
        let temp = +this.numberToConvert;
        let temp2 = 0
        let power = 0
        while (temp > 0) {
            let digit = Number(temp % 10)
            temp2 += Number(Math.pow(+this.base1, power) * digit)
            power = Number(power + 1)
            temp = Number(Math.floor(temp / 10))
        }
        return temp2.toString();
    }

    createHexaMap(): any {
        let m = new Map();

        let alpha = 'A'
        let digit = 0
        //let map = new Map()
        while (digit < 10) {
            m.set(digit.toString(), digit)
            digit++
        }
        while (digit < 16) {
            m.set(alpha, digit)
            alpha = String.fromCharCode(alpha.charCodeAt(0) + 1)
            digit++
        }
        // console.log(m)
        return m;
    }

    convertHexaToDecimal(): string {

        //console.log(m)
        let temp2 = 0
        let power = 0
        // console.log("number to convert: " + this.numberToConvert)
        let reversedString = this.numberToConvert.toUpperCase().split("").reverse().join("")
        for (let char1 of reversedString) {
            // console.log(m.get(char1))
            let digit = this.m.get(char1)
            temp2 = (Math.pow(16, power) * digit) + temp2
            power++;
        }
        return temp2.toString();
        // for (let entry of map.entries()) {
        //     console.log(entry[0], entry[1]);
        // }

    }
}