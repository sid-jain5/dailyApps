import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { NumberConvert } from '../converters/numberConvert'
import { Router } from '@angular/router'
import { element } from 'protractor';
import { LengthConvert } from '../converters/lengthConvert';
import { TemperatureConvert } from '../converters/temperatureConvert'

@Component({
  selector: 'app-converter',
  templateUrl: './converter.component.html',
  styleUrls: ['./converter.component.css']
})
export class ConverterComponent implements OnInit {

  currentConverter: string = 'choose';
  fromSubUnit: string = 'Select Unit';
  gibber: string = 'gibberish'
  toSubUnit: string = 'Select Unit'
  convertForm: FormGroup
  label1: String = "Binary Number:"
  label2: String = "Decimal Number:"
  validatePattern: string = '^[01]{1,20}$'
  // convertList = ['length', 'weight', 'temperature', 'number system', 'computer memory', 'currency']
  convertMap = this.createConvertTypelist()
  convertMapKeys = Array.from(this.convertMap.keys())
  constructor(private fb: FormBuilder, private router: Router) {
  }

  ngOnInit() {
    this.convertForm = this.fb.group({
      binaryNumber: ['', [Validators.required, Validators.pattern(this.validatePattern)]],
      decimalNumber: ['']
    });

    //this.onChanges();
  }

  //, this.validateSelect.bind(this)
  // validateSelect(control:FormControl) {
  //   console.log(control.value)
  //   this.convert(control.value)
  // }

  // onChanges(): void {
  //   this.convertForm.get('binaryNumber').valueChanges.subscribe(val => {
  //     if(this.currentConverter=='choose' || this.fromSubUnit=='Select Unit' || this.toSubUnit=='Select Unit'){
  //       alert("chosen")
  //       this.router.navigate(['converter'])
  //     }
  //     else if (this.convertForm.get('binaryNumber').valid){
  //       console.log(this.currentConverter)
  //       this.convert();
  //     }
  //     else {
  //       alert("illegal value")
  //       let a = this.convertForm.get('binaryNumber').value
  //       a = Math.floor(a / 10)
  //       this.convertForm.patchValue(
  //         {
  //           binaryNumber: a
  //         }
  //       )
  //       //this.onChanges();
  //     }
  //   })
  // }

  toggleFunction() {
    alert("toggle button press")
  }

  onChange1(obj) {
    this.currentConverter = obj
    this.fromSubUnit = 'Select Unit';
    this.toSubUnit = 'Select Unit'
    //   // if (obj == "number system") {
    //   //   alert("continue")
    //   // }
    //   // else {
    //   //   //console.log("here")
    //   //   alert("feature not available yet")
    //   // }
  }

  onChange2(obj2: string) {
    if (this.currentConverter == 'choose') {
      alert("Please choose the converter type")
    }
    else if (obj2.substring(obj2.length - 1) == 'a') {
      this.fromSubUnit = obj2.substring(0, obj2.length - 1)
    }
    else if (obj2.substring(obj2.length - 1) == 'b') {
      this.toSubUnit = obj2.substring(0, obj2.length - 1)
    }
    else {
      alert('Some error occured')
    }

  }
  createConvertTypelist() {
    let convertList = new Map()
    convertList.set('length', ['deca', 'hecto', 'kilo', 'mega', 'giga', 'tera', 'peta', 'deci', 'centi', 
    'mili', 'micro', 'nano', 'pico', 'femto'])
    convertList.set('weight', ['abc', 'def'])
    convertList.set('temperature', ['celcius', 'farenheit', 'kelvin'])
    convertList.set('number system', ['binary', 'decimal', 'octa', 'hexadecimal'])
    convertList.set('computer memory', ['bits', 'bytes', 'kb', 'mb', 'gb', 'tb'])
    convertList.set('currency', ['country1', 'country2'])

    return convertList
  }

  convert() {
    let temp = this.convertForm.get('binaryNumber').value
    if(temp=='' || temp==null){
      return
    }
    let ans:string
    if (this.currentConverter == 'number system') {

      let nc: NumberConvert = new NumberConvert(this.fromSubUnit, this.toSubUnit, temp);
      ans = nc.convertNum()
      this.convertForm.controls['decimalNumber'].setValue(ans)
    }
    else if(this.currentConverter == 'length' || this.currentConverter == 'weight'){
      let lc : LengthConvert = new LengthConvert()
      ans = lc.converter(this.fromSubUnit, this.toSubUnit, temp)
    }
    else if(this.currentConverter == 'temperature'){
      let tc:TemperatureConvert = new TemperatureConvert(this.fromSubUnit, this.toSubUnit, temp)
      ans = tc.convert()
    }
    else{
      alert("feature will be available soon")
    }
    this.convertForm.controls['decimalNumber'].setValue(ans)
  }

}
