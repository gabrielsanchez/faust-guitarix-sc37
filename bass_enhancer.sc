FaustBassEnhancer : MultiOutUGen
{
  *ar { | in1, in2, frequency(100.0), harmonicsdb(0.0) |
      ^this.multiNew('audio', in1, in2, frequency, harmonicsdb)
  }

  *kr { | in1, in2, frequency(100.0), harmonicsdb(0.0) |
      ^this.multiNew('control', in1, in2, frequency, harmonicsdb)
  } 

  checkInputs {
    if (rate == 'audio', {
      2.do({|i|
        if (inputs.at(i).rate != 'audio', {
          ^(" input at index " + i + "(" + inputs.at(i) + 
            ") is not audio rate");
        });
      });
    });
    ^this.checkValidInputs
  }

  init { | ... theInputs |
      inputs = theInputs
      ^this.initOutputs(2, rate)
  }

  name { ^"FaustBassEnhancer" }


  info { ^"Generated with Faust" }
}

