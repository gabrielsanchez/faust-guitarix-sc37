FaustAmp : UGen
{
  *ar { | in1, out_master(0.0) |
      ^this.multiNew('audio', in1, out_master)
  }

  *kr { | in1, out_master(0.0) |
      ^this.multiNew('control', in1, out_master)
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

  name { ^"FaustAmp" }


  info { ^"Generated with Faust" }
}

