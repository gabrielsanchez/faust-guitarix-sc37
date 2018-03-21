FaustAmp2 : UGen
{
  *ar { | in1, pregain(-6.0), gain1(-6.0) |
      ^this.multiNew('audio', in1, pregain, gain1)
  }

  *kr { | in1, pregain(-6.0), gain1(-6.0) |
      ^this.multiNew('control', in1, pregain, gain1)
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

  name { ^"FaustAmp2" }


  info { ^"Generated with Faust" }
}

