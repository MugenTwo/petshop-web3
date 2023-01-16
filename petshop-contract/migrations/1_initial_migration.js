var AdoptionContract = artifacts.require("AdoptionContract");

module.exports = function(deployer) {
  deployer.deploy(AdoptionContract, "0x3dEE3252C6B096d902BD82c56441fBE01e925A23");
};