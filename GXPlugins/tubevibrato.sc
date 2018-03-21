FaustTubevibrato : UGen
{
  *ar { | in1, vibrato(0.0) |
      ^this.multiNew('audio', in1, vibrato)
  }

  *kr { | in1, vibrato(0.0) |
      ^this.multiNew('control', in1, vibrato)
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

  name { ^"FaustTubevibrato" }


  info { ^"Generated with Faust" }
}

