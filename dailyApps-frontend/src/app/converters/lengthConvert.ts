export class LengthConvert {

    convertToMeter(unit: string, biggerUnits: string[], smallerUnits: string[]): number {
        var index1 = biggerUnits.indexOf(unit)
        var index2 = smallerUnits.indexOf(unit)

        var left = 0
        // unit1 is metres
        if (index1 == -1 && index2 == -1) {
            left = 1
        }

        //converting bigger unit to metres
        else if (index1 != -1) {
            left = Math.pow(10, index1)
        }
        else if (index2 != -1) {
            left = Math.pow(10, -index1)
        }
        else {
            console.log("Error while converting unit1")
        }

        return left
    }
    convertFromMeter(unit, biggerUnits, smallerUnits): number {

        var index1 = biggerUnits.indexOf(unit)
        var index2 = smallerUnits.indexOf(unit)

        var left = 0
        // unit1 is metres
        if (index1 == -1 && index2 == -1) {
            left = 1
        }

        //converting bigger unit to metres
        else if (index1 != -1) {
            left = Math.pow(10, -index1)
        }
        else if (index2 != -1) {
            left = Math.pow(10, index1)
        }
        else {
            console.log("Error while converting unit2")
        }

        return left
    }
    converter(unit1: string, unit2: string, data: number): string {
        //garb are garbage values for specified index
        let biggerUnits: string[] = ['garb', 'deca', 'hecto', 'kilo', 'garb1', 'garb2', 'mega',
            'garb3', 'garb4', 'giga', 'garb5', 'garb6', 'tera', 'garb7', 'garb7', 'peta']

        let smallerUnits: string[] = ['garb', 'deci', 'centi', 'mili', 'garb1', 'garb2', 'micro',
            'garb3', 'garb4', 'nano', 'garb5', 'garb6', 'pico', 'garb7', 'garb7', 'femto']

        let left = this.convertToMeter(unit1, biggerUnits, smallerUnits);
        let right = this.convertFromMeter(unit2, biggerUnits, smallerUnits);

        return (left * right * data).toString();
    }
}