FaustManual : UGen
{
  *ar { | in1, ve_crybaby_level(0.1), ve_crybaby_wah(0.0), ve_crybaby_wet_dry(100.0) |
      ^this.multiNew('audio', in1, ve_crybaby_level, ve_crybaby_wah, ve_crybaby_wet_dry)
  }

  *kr { | in1, ve_crybaby_level(0.1), ve_crybaby_wah(0.0), ve_crybaby_wet_dry(100.0) |
      ^this.multiNew('control', in1, ve_crybaby_level, ve_crybaby_wah, ve_crybaby_wet_dry)
  } 

  checkInputs {
    if (rate == 'audio', {
      1.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  name { ^"FaustManual" }


  info { ^"Generated with Faust" }
}

