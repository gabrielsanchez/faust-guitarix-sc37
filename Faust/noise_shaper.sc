FaustShaper : UGen
{
  *ar { | in1, sharper(1.0) |
      ^this.multiNew('audio', in1, sharper)
  }

  *kr { | in1, sharper(1.0) |
      ^this.multiNew('control', in1, sharper)
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

  name { ^"FaustShaper" }


  info { ^"Generated with Faust" }
}

