FaustDelay : UGen
{
  *ar { | in1, bpm(120.0), gain(0.0) |
      ^this.multiNew('audio', in1, bpm, gain)
  }

  *kr { | in1, bpm(120.0), gain(0.0) |
      ^this.multiNew('control', in1, bpm, gain)
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

  name { ^"FaustDelay" }


  info { ^"Generated with Faust" }
}

