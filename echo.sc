FaustEcho : UGen
{
  *ar { | in1, bpm(120.0), percent(0.0) |
      ^this.multiNew('audio', in1, bpm, percent)
  }

  *kr { | in1, bpm(120.0), percent(0.0) |
      ^this.multiNew('control', in1, bpm, percent)
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

  name { ^"FaustEcho" }


  info { ^"Generated with Faust" }
}

