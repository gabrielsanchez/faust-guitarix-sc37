FaustMaestroWah : UGen
{
  *ar { | in1, wah_wah(0.0), wah_freq(24.0), wah_mode(0.0), wah_wet_dry(100.0) |
      ^this.multiNew('audio', in1, wah_wah, wah_freq, wah_mode, wah_wet_dry)
  }

  *kr { | in1, wah_wah(0.0), wah_freq(24.0), wah_mode(0.0), wah_wet_dry(100.0) |
      ^this.multiNew('control', in1, wah_wah, wah_freq, wah_mode, wah_wet_dry)
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

  name { ^"FaustMaestroWah" }


  info { ^"Generated with Faust" }
}

