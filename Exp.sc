FaustExp : UGen
{
  *ar { | in1, on(0.0), sine(0.0), depth(0.5), freq(5.0), wet_dry_0(100.0), wet_dry_1(0.0) |
      ^this.multiNew('audio', in1, on, sine, depth, freq, wet_dry_0, wet_dry_1)
  }

  *kr { | in1, on(0.0), sine(0.0), depth(0.5), freq(5.0), wet_dry_0(100.0), wet_dry_1(0.0) |
      ^this.multiNew('control', in1, on, sine, depth, freq, wet_dry_0, wet_dry_1)
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

  name { ^"FaustExp" }


  info { ^"Generated with Faust" }
}

